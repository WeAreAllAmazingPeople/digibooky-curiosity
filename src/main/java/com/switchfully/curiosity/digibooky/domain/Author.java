package com.switchfully.curiosity.digibooky.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Author {
    private final Logger LOGGER = LoggerFactory.getLogger(Author.class);

    private final String firstname;
    private final String lastname;

    public Author(String firstname, String lastname) {
        if (firstname == null) {
            LOGGER.info("Author's first name was null, so an empty string was provided to register the book");
            this.firstname = "";
        } else {
            this.firstname = firstname;
        }
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String retrieveFullname() {
        return firstname + " " + lastname;
    }
}
