package com.github.eunsukko.application.port.in;

import com.github.eunsukko.application.port.BookRegister;
import com.github.eunsukko.application.port.in.command.BookRegisterCommand;

import java.util.List;

public interface BookRegisterUseCase {
    BookRegister register(BookRegisterCommand command);

    List<BookRegister> register(List<BookRegisterCommand> command);
}
