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
        return new Isbn(isbnString);
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
