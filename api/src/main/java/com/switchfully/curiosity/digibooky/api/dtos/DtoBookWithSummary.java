package com.switchfully.curiosity.digibooky.api.dtos;

import com.switchfully.curiosity.digibooky.domain.entities.books.Author;

import java.util.UUID;

public class DtoBookWithSummary {

    private String ISBN;
    private Author author;
    private String title;
    private UUID id;
    private String summary;

    public DtoBookWithSummary setTitle(String title){
        this.title = title;
        return this;
    }

    public DtoBookWithSummary setISBN(String ISBN){
        this.ISBN = ISBN;
        return this;
    }

    public DtoBookWithSummary setAuthor(Author author){
        this.author = author;
        return this;
    }

    public DtoBookWithSummary setID(UUID id){
        this.id = id;
        return this;
    }

    public DtoBookWithSummary setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public UUID getID() {
        return this.id;
    }

    public String getSummary() {
        return summary;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }
}
