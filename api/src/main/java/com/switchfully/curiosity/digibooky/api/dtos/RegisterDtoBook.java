package com.switchfully.curiosity.digibooky.api.dtos;


public class RegisterDtoBook {

    private String ISBN;
    private String authorLastName;
    private String title;

    public RegisterDtoBook setISBN(String ISBN) {
        this.ISBN = ISBN;
        return this;
    }

    public RegisterDtoBook setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public RegisterDtoBook setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getTitle() {
        return title;
    }
}
