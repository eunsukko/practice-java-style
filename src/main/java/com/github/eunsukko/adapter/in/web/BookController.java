package com.github.eunsukko.adapter.in.web;

import com.github.eunsukko.adapter.in.web.dto.BookRegisterRequest;
import com.github.eunsukko.adapter.in.web.dto.BookRegisterResponse;
import com.github.eunsukko.application.port.in.BookRegisterUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController(value = "/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookRegisterUseCase registerUseCase;

    @PostMapping
    public BookRegisterResponse registerBook(@RequestBody BookRegisterRequest request) {
        return null;
    }
}
