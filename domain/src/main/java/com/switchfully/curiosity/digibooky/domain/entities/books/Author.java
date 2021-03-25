package com.switchfully.curiosity.digibooky.domain.entities.books;

public final class Author {
    private final String firstname;
    private final String lastname;

    public Author(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }
}
