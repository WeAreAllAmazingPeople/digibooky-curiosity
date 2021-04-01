package com.switchfully.curiosity.digibooky.domain.entities;

import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import com.switchfully.curiosity.digibooky.domain.entities.users.User;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {
    public static final int MAX_LOAN_DURATION = 21;
    private final UUID id; //Id of transaction (loan)
    private final User user;
    private final Book book;
    private final LocalDate dueDate;

    public Loan(User user, Book book) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.book = book;
        this.dueDate = LocalDate.now().plusDays(MAX_LOAN_DURATION);
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
