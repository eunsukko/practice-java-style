package com.github.eunsukko.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Isbn {
    private final String isbn13;

    public static Isbn from(String isbnString) {
        return new Isbn(isbnString);
    }
}
