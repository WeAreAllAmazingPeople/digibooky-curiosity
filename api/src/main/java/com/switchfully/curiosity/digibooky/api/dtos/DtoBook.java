package com.switchfully.curiosity.digibooky.api.dtos;

import com.switchfully.curiosity.digibooky.domain.entities.books.Author;

import java.util.UUID;

public class DtoBook {

    private String ISBN;
    private Author author;
    private String title;
    private UUID id;

    public DtoBook setTitle(String title){
        this.title = title;
        return this;
    }

    public DtoBook setISBN(String ISBN){
        this.ISBN = ISBN;
        return this;
    }

    public DtoBook setAuthor( Author author){
        this.author = author;
        return this;
    }

    public DtoBook setID( UUID id){
        this.id = id;
        return this;
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
