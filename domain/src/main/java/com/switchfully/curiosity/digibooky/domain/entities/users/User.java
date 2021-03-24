package com.switchfully.curiosity.digibooky.domain.entities.users;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String inss;    //TODO make value object
    private final String lastname;
    private final String firstname;
    private final String email;    //TODO make value object
    private final Address address;

    public User(String inss, String lastname, String firstname, String email, Address address) {
        this.id = UUID.randomUUID();
        this.inss = inss;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.address = address;
    }

}
