package com.switchfully.curiosity.digibooky.domain.entities.books;

import java.util.UUID;

public class Book {
    private final UUID id;
    private final String ISBN;     //TODO make value object with ISBN
    private final Author author;
    private final String title;
    private final String summary;     //QUESTION summary of book story or infos?

    public Book(String ISBN, Author author, String title, String summary) {
        this.id = UUID.randomUUID();
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.summary = summary;
    }


    public String getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public UUID getId() {
        return id;
    }
}
