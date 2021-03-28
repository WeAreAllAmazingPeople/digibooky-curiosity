package com.switchfully.curiosity.digibooky.api.dtos;

import com.switchfully.curiosity.digibooky.domain.entities.books.Author;

import java.util.UUID;

public class DtoBookWithSummary {

    private String isbn;
    private Author author;
    private String title;
    private UUID id;
    private String summary;

    public DtoBookWithSummary setTitle(String title) {
        this.title = title;
        return this;
    }

    public DtoBookWithSummary setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public DtoBookWithSummary setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public DtoBookWithSummary setId(UUID id) {
        this.id = id;
        return this;
    }

    public DtoBookWithSummary setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public UUID getId() {
        return id;
    }


}
