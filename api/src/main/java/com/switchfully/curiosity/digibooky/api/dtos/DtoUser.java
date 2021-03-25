package com.switchfully.curiosity.digibooky.api.dtos;

import com.switchfully.curiosity.digibooky.domain.entities.users.Address;

import java.util.UUID;

public class DtoUser {

    private UUID id;
    private String INSS;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;

    public UUID getId() {
        return id;
    }

    public DtoUser setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getINSS() {
        return INSS;
    }

    public DtoUser setINSS(String INSS) {
        this.INSS = INSS;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public DtoUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public DtoUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public DtoUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public DtoUser setAddress(Address address) {
        this.address = address;
        return this;
    }
}
