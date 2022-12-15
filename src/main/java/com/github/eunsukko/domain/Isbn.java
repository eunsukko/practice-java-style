package com.github.eunsukko.domain;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@RequiredArgsConstructor
public class Isbn {
    private final String isbn13;

    public static Isbn from(String isbnString) {
        if (isbnString.length() != 10
            && isbnString.length() != 13) {
            throw new IllegalArgumentException("Isbn 은 10 or 13 자리의 숫자입니다");
        }

        if (hasNotNumberCharacter(isbnString)) {
            throw new IllegalArgumentException("Isbn 은 숫자로 이루어져야 합니다");
        }

        return new Isbn(isbnString);
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
