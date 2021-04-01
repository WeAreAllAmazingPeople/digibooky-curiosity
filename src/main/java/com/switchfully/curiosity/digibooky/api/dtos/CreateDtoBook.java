package com.switchfully.curiosity.digibooky.api.dtos;


import com.switchfully.curiosity.digibooky.domain.entities.books.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateDtoBook {

    private final Logger LOGGER = LoggerFactory.getLogger(CreateDtoBook.class);

    private String isbn;
    private Author author;
    private String title;
    private String summary;

    public CreateDtoBook setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public CreateDtoBook setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public CreateDtoBook setTitle(String title) {
        this.title = title;
        return this;
    }

    public CreateDtoBook setSummary(String summary) {
        this.summary = summary;
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

    public String getSummary() {
        return summary;
    }
}