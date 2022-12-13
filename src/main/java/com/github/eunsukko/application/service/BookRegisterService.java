package com.github.eunsukko.application.service;

import com.github.eunsukko.application.port.BookRegister;
import com.github.eunsukko.application.port.in.BookRegisterUseCase;
import com.github.eunsukko.application.port.in.command.BookRegisterCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookRegisterService implements BookRegisterUseCase {

    @Override
    public BookRegister register(BookRegisterCommand command) {
        return null;
    }

    @Override
    public List<BookRegister> register(List<BookRegisterCommand> command) {
        return null;
    }
}
