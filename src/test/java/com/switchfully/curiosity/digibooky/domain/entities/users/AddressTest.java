package com.switchfully.curiosity.digibooky.domain.entities.users;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void isValidAddress_GivenCity_ThenAddressIsValid(){
        //Given
        String city = "city";
        //When
        //Then
        assertTrue(Address.isValidAddress(city));
    }

    @Test
    void isValidAddress_GivenNoCity_ThenAddressIsNotValid(){
        //Given
        String city = null;
        //When
        //Then
        assertFalse(Address.isValidAddress(city));
    }

    @Test
    void constructor_GivenNoCity_WhenCallingConstructor_ThenThrowsNewIllegalArgumentException(){
        //Given
        String streetName = "streetName";
        String streetNumber = "streetNumber";
        String postCode = "postCode";
        String city = null;

        //When
        Executable callConstructor = () -> new Address(streetName, streetNumber, postCode, city);

        //Then
        assertThrows(IllegalArgumentException.class, callConstructor);
    }
}

