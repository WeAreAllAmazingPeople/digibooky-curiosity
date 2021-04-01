package com.switchfully.curiosity.digibooky.dtos;

import com.switchfully.curiosity.digibooky.domain.Address;

public class CreateDtoUser {

    private String INSS;
    private String email;
    private String lastName;
    private String firstName;
    private Address address;

    public String getInss() {
        return INSS;
    }

    public CreateDtoUser setINSS(String INSS) {
        this.INSS = INSS;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateDtoUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateDtoUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CreateDtoUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public CreateDtoUser setAddress(Address address) {
        this.address = address;
        return this;
    }



}
