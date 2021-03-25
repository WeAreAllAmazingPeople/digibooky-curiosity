package com.switchfully.curiosity.digibooky.domain.entities.users;

public final class Address {
    private final String streetName;
    private final String streetNumber;
    private final String postCode;
    private final String city;

    public Address(String streetName, String streetNumber, String postCode, String city) {
        if (!isValidAddress(city)) throw new IllegalArgumentException("Illegal argument was given");
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
    }

    public static boolean isValidAddress(String city) {
        return city!=null;
    }
}
