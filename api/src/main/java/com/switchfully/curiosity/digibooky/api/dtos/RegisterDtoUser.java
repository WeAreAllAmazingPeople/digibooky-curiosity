package com.switchfully.curiosity.digibooky.api.dtos;

import com.switchfully.curiosity.digibooky.domain.entities.users.Address;

public class RegisterDtoUser {

    private String INSS;
    private String email;
    private String lastName;
    private String firstName;
    private Address address;

    public String getINSS() {
        return INSS;
    }

    public RegisterDtoUser setINSS(String INSS) {
        this.INSS = INSS;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterDtoUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterDtoUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisterDtoUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public RegisterDtoUser setAddress(Address address) {
        this.address = address;
        return this;
    }



}
