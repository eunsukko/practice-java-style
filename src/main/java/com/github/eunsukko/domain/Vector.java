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

    private static boolean hasNotNumberCharacter(String isbnString) {
        return !hasOnlyNumberCharacter(isbnString);
    }

    private static boolean hasOnlyNumberCharacter(String isbnString) {
        return isbnString.chars()
                .allMatch(Character::isDigit);
    }
}
