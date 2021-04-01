package com.switchfully.curiosity.digibooky.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    //TODO @BeforeEach test

    @Test
    void isValidUser_GivenINSS_ThenUserIsValid() {
        //Given
        String inss = "inss";
        String lastName = "lastname";
        String email = "user@example.com";
        Address address = new Address("streetname", "123", "1230", "abc");

        //When
        //Then
        assertTrue(User.isValidUser(inss, lastName, email, address));
    }

    @Test
    void isValidUser_GivenNoINSS_ThenUserNotValid(){
        //Given
        String inss = null;
        String lastName = "lastname";
        String email = "user@example.com";
        Address address = new Address("streetname", "123", "1230", "abc");

        //When
        //Then
        assertFalse(User.isValidUser(inss, lastName, email, address));
    }


   @Test
    void isValidUser_GivenLastname_ThenUserIsValid(){
        //Given
       String inss = "inss";
       String lastName = "lastname";
       String email = "user@example.com";
       Address address = new Address("streetname", "123", "1230", "abc");
       //When
       //Then
       assertTrue(User.isValidUser(inss,lastName, email, address));
   }

    @Test
    void isValidUser_GivenNoLastname_ThenUserIsNotValid(){
        //Given
        String inss = "inss";
        String lastName = null;
        String email = "user@example.com";
        Address address = new Address("streetname", "123", "1230", "abc");

        //When
        //Then
        assertFalse(User.isValidUser(inss,lastName, email, address));
    }

    @Test
    void constructor_GivenIllegalArguments_WhenCallingConstructor_ThenThrowsNewIllegalArgumentException(){
        //Given
        String inss = null;
        String lastName = "lastName";
        String firstName = "firstName";
        String email = "user@example.com";
        Address address = new Address("streetName", "streetNumber", "postCode", "city");

        //When
        Executable callConstructor = () -> new User(inss, lastName, firstName, email, address);

        //Then
        assertThrows(IllegalArgumentException.class, callConstructor);
    }

    @Test
    void isValidUser_GivenEmail_ThenUserIsValid(){
        //Given
        String inss = "inss";
        String lastName = "lastname";
        String email = "user@example.com";
        Address address = new Address("streetname", "123", "1230", "abc");

        //When
        //Then
        assertTrue(User.isValidUser(inss,lastName,email, address));
    }

    @Test
    void isValidUser_GivenNoEmail_ThenUserIsNotValid(){
        //Given
        String inss = "inss";
        String lastName = "lastname";
        String email = null;
        Address address = new Address("streetname", "123", "1230", "abc");

        //When
        //Then
        assertFalse(User.isValidUser(inss,lastName, email, address));
    }

    @Test
    void isValidUser_GivenWrongEmailFormat_ThenUserIsNotValid(){
        //Given
        String inss = "inss";
        String lastName = "lastname";
        String email = "email is not right format";
        Address address = new Address("streetname", "123", "1230", "abc");

        //When
        //Then
        assertFalse(User.isValidUser(inss,lastName,email, address));
    }

    @Test
    void isValidUser_GivenAddress_ThenUserIsValid(){
        //Given
        String inss = "1230";
        String lastname = "lastname";
        String email = "user@example.com";
        Address address = new Address("streetname", "123", "1230", "abc");
        //When
        //Then
        assertTrue(User.isValidUser(inss, lastname, email, address));
    }

    @Test
    void isValidUser_GivenNullAddress_ThenUserIsNotValid(){
        //Given
        String inss = "1230";
        String lastname = "lastname";
        String email = "user@example.com";
        Address address = null;
        //When
        //Then
        assertFalse(User.isValidUser(inss, lastname, email, address));
    }
}
