package com.switchfully.curiosity.digibooky.dtos;

import com.switchfully.curiosity.digibooky.domain.Author;

import java.util.UUID;

public class DtoBookWithoutSummary {

    private String isbn;
    private Author author;
    private String title;
    private UUID id;

    public DtoBookWithoutSummary setTitle(String title) {
        this.title = title;
        return this;
    }

    public DtoBookWithoutSummary setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public DtoBookWithoutSummary setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public DtoBookWithoutSummary setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getIsbn() {
        return isbn;
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
