package com.switchfully.curiosity.digibooky.domain.entities.users;

import java.util.UUID;

public class User {
    private static final String EMAIL_FORMAT = "^\\w+@\\w+\\.\\w+$";
    private final UUID id;
    private final String inss;    //TODO make value object
    private final String lastname;
    private final String firstname;
    private final String email;    //TODO make value object
    private final Address address;


    public User(String inss, String lastname, String firstname, String email, Address address) {
        if (!isValidUser(inss, lastname, email, address)) {
            throw new IllegalArgumentException("Cannot create user, illegal arguments provided");
        }
        this.id = UUID.randomUUID();
        this.inss = inss;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.address = address;
    }

    public static boolean isValidUser(String inss, String lastname, String email, Address address) {
        return  inss != null
                && lastname != null
                && email != null
                && email.matches(EMAIL_FORMAT)
                && address != null;
    }

    public static String getEmailFormat() {
        return EMAIL_FORMAT;
    }

    public UUID getId() {
        return id;
    }

    public String getInss() {
        return inss;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
