package com.github.eunsukko.adapter.in.web.dto;

import com.github.eunsukko.application.port.in.command.BookRegisterCommand;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BookRegisterRequest {
    private String title;
    private String isbn; // isbn10 or isbn13
    private String author;
    private String publisher;

    public BookRegisterRequest(String title, String isbn, String author, String publisher) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
    }

    public BookRegisterCommand toCommand(LocalDateTime currentDateTime) {
        return BookRegisterCommand.of(title, isbn, author, publisher, currentDateTime);
    }
}
