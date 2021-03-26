package com.switchfully.curiosity.digibooky.api.dtos;

import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import com.switchfully.curiosity.digibooky.domain.entities.users.User;

import java.time.LocalDate;
import java.util.UUID;

public class DtoLoan {

    private UUID id; //Id of transaction (loan)
    private User user;
    private Book book;
    private LocalDate dueDate;

    public UUID getId() {
        return id;
    }

    public DtoLoan setId(UUID id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public DtoLoan setUser(User user) {
        this.user = user;
        return this;
    }

    public Book getBook() {
        return book;
    }

    public DtoLoan setBook(Book book) {
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
