package com.github.eunsukko.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Vector {
    private final List<Integer> numbers;

    public static Vector from(List<Integer> numbers) {
        return new Vector(numbers);
    }

    public static Vector fromNumberString(String numberString) {
        if (hasNotNumberCharacter(numberString)) {
            throw new IllegalArgumentException("숫자 이외의 글자를 포함할 수 없습니다");
        }

        var numbers = numberString.chars()
                .map(codePoint -> codePoint - Character.valueOf('0'))
                .boxed()
                .collect(Collectors.toList());

        return from(numbers);
    }

    private static boolean hasNotNumberCharacter(String numberString) {
        return !hasOnlyNumberCharacter(numberString);
    }

    private static boolean hasOnlyNumberCharacter(String numberString) {
        return numberString.chars()
                .allMatch(Character::isDigit);
    }

    public long dotProduct(Vector vector) {
        if (size() != vector.size()) {
            String message = String.format("size 가 서로 다른 vector 는 비교할 수 없습니다 vector1: %s, vector2: %s", this, vector);
            throw new IllegalArgumentException(message);
        }

        long result = 0L;
        for (int i = 0; i < size(); i++) {
            result += (long) numberAt(i) * vector.numberAt(i);
        }

        return result;
    }

    public int size() {
        return numbers.size();
    }

    private int numberAt(int index) {
        return numbers.get(index);
    }
}
