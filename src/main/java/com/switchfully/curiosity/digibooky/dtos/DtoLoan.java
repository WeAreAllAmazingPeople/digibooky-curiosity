package com.switchfully.curiosity.digibooky.dtos;

import java.time.LocalDate;
import java.util.UUID;

public class DtoLoan {

    private UUID id; //Id of transaction (loan)
    private DtoUser user;
    private DtoBook book;
    private LocalDate dueDate;

    public UUID getId() {
        return id;
    }

    public DtoLoan setId(UUID id) {
        this.id = id;
        return this;
    }

    public DtoUser getUser() {
        return user;
    }

    public DtoLoan setUser(DtoUser user) {
        this.user = user;
        return this;
    }

    public DtoBook getBook() {
        return book;
    }

    public DtoLoan setBook(DtoBook book) {
        this.book = book;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public DtoLoan setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
