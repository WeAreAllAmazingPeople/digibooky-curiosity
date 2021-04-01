package com.switchfully.curiosity.digibooky.dtos;

import com.switchfully.curiosity.digibooky.domain.Author;

import java.util.UUID;

public class DtoBook {

    private String isbn;
    private Author author;
    private String title;
    private UUID id;
    private String summary;

    public DtoBook setTitle(String title) {
        this.title = title;
        return this;
    }

    public DtoBook setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public DtoBook setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public DtoBook setId(UUID id) {
        this.id = id;
        return this;
    }

    public DtoBook setSummary(String summary) {
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
