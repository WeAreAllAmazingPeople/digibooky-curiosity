package com.switchfully.curiosity.digibooky.api.dtos;


import com.switchfully.curiosity.digibooky.domain.entities.books.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterDtoBook {

    private final Logger LOGGER = LoggerFactory.getLogger(RegisterDtoBook.class);

    private String ISBN;
    private Author author;
    private String title;
    private String summary;

    public RegisterDtoBook setISBN(String ISBN) {
        this.ISBN = ISBN;
        return this;
    }

    public RegisterDtoBook setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public RegisterDtoBook setTitle(String title) {
        this.title = title;
        return this;
    }

    public RegisterDtoBook setSummary(String summary) {
        this.summary = summary;
        return this;
    }


    public String getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }
/*
    public String getAuthorFirstname() {
        return author.getFirstname();
    }

    public String getAuthorLastName() {
        return author.getLastname();
    }

 */

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }
}