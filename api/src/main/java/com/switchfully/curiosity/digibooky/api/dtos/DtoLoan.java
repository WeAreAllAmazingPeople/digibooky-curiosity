package com.switchfully.curiosity.digibooky.api.dtos;

import java.time.LocalDate;
import java.util.UUID;

public class DtoLoan {

    private UUID id; //Id of transaction (loan)
    private DtoUser user;
    private DtoBookWithSummary book;
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

    public DtoBookWithSummary getBook() {
        return book;
    }

    public DtoLoan setBook(DtoBookWithSummary book) {
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
