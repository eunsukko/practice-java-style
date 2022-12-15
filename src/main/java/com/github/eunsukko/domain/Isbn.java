package com.github.eunsukko.domain;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@RequiredArgsConstructor
public class Isbn {
    private final String isbn13;

    public static Isbn from(String isbnString) {
        if (isbnString.length() == 10) {
            return isbn10(isbnString);
        }

        if (isbnString.length() == 13) {
            return isbn13(isbnString);
        }

        throw new IllegalArgumentException("Isbn 은 10 or 13 자리의 숫자입니다");
    }

    public static Isbn isbn13(String isbnString) {
        if (hasNotNumberCharacter(isbnString)) {
            throw new IllegalArgumentException("Isbn 은 숫자로 이루어져야 합니다");
        }

        if (calculateCheckNumber13(isbnString) != checkNumber(isbnString)) {
            String message = String.format("\'%s\'은 체크번호가 틀립니다. (got: %d, expected: %d)", isbnString, calculateCheckNumber13(isbnString), checkNumber(isbnString));
            throw new IllegalArgumentException(message);
        }

        return new Isbn(isbnString);
    }

    // 출처: 나무위키
    // 1. 13 자리 ISBN을 (A,B,C,D,E,F,G,H,I,J,K,L,M) 라 하고, 이 벡터를 b 라 한다.
    // 2. a = (1,3,1,3,1,3,1,3,1,3,1,3,1) 라 한다.
    // 3. ( a · b ) % 10 의 값이 0이 되어야 한다.
    private static int calculateCheckNumber13(String isbnString) {
        Vector baseVector = Vector.from(Arrays.asList(
                1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3
        ));

        Vector targetVector = Vector.fromNumberString(isbnString.substring(0, 12));

        int remainder = (int) (targetVector.dotProduct(baseVector) % 10);

        return (10 - remainder) % 10;
    }

    private static int checkNumber(String isbnString) {
        char lastCh = isbnString.charAt(isbnString.length() - 1);

        if (lastCh == 'X' || lastCh == 'x') {
            return 10;
        }

        return lastCh - '0';
    }

    public static Isbn isbn10(String isbnString) {
        if (hasNotNumberCharacter(isbnString)) {
            throw new IllegalArgumentException("Isbn 은 숫자로 이루어져야 합니다");
        }

        if (calculateCheckNumber10(isbnString) != checkNumber(isbnString)) {
            String message = String.format("\'%s\'은 체크번호가 틀립니다. (got: %d, expected: %d)", isbnString, calculateCheckNumber10(isbnString), checkNumber(isbnString));
            throw new IllegalArgumentException(message);
        }

        return new Isbn(toIsbn13String(isbnString));
    }

    private static String toIsbn13String(String isbn10String) {
        var tmpIsbn13String = String.format("978%s0", isbn10String.substring(0, 9));
        var isbn13String = String.format("%s%d",
                tmpIsbn13String.substring(0, 12),
                calculateCheckNumber13(tmpIsbn13String));

        return isbn13String;
    }

    // 출처: 나무위키
    // 1. 10 자리 ISBN을 (A,B,C,D,E,F,G,H,I,J) 라 하고, 마지막 J를 제외한 (A,B,C,D,E,F,G,H,I) 벡터를 만든다. 이 벡터를 b 라 한다.
    // 2. a = (1,2,3,4,5,6,7,8,9) 라 한다.
    // 3. ( a · b ) % 11 의 값을 J 로 정하되, 이 값이 10일 경우는 X로 표기한다. 점곱은 유클리드 내적이다. A*1+B*2+C*3+.....9*I
    private static int calculateCheckNumber10(String isbnString) {
        Vector baseVector = Vector.from(Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9
        ));

        Vector targetVector = Vector.fromNumberString(isbnString.substring(0, 9));

        return (int) (targetVector.dotProduct(baseVector) % 11);
    }

    private static boolean hasNotNumberCharacter(String isbnString) {
        return !hasOnlyNumberCharacter(isbnString);
    }

    private static boolean hasOnlyNumberCharacter(String isbnString) {
        return isbnString.chars()
                .allMatch(Character::isDigit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Isbn isbn = (Isbn) o;
        return Objects.equals(isbn13, isbn.isbn13);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn13);
    }

    @Override
    public String toString() {
        return isbn13;
    }
}
