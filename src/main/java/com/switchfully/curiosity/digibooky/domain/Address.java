package com.switchfully.curiosity.digibooky.domain;

public final class Address {
    private final String streetName;
    private final String streetNumber;
    private final String postCode;
    private final String city;

    public Address(String streetName, String streetNumber, String postCode, String city) {
        if (!isValidAddress(city)) throw new IllegalArgumentException("Cannot create address, illegal arguments provided");
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
    }

    public static boolean isValidAddress(String city) {
        return city!=null;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }
}
