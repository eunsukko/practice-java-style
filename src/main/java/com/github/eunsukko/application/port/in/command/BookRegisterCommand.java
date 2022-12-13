package com.github.eunsukko.application.port.in.command;


import com.github.eunsukko.domain.Isbn;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@RequiredArgsConstructor
public class BookRegisterCommand {
    private final String title;
    private final Isbn isbn;
    private final String author;
    private final String publisher;
    private final LocalDateTime commandDateTime;

    public static BookRegisterCommand of(String title,
                                         String isbnString,
                                         String author,
                                         String publisher,
                                         LocalDateTime commandDateTime) {
        return new BookRegisterCommand(
                title,
                Isbn.from(isbnString) ,
                author,
                publisher,
                commandDateTime);
    }

}
