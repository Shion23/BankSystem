package com.example.bankaccsystem.model;

public class Address {
    private int addressId;
    private String street;
    private String houseNumber;
    private String zipcode;
    private String city;

    public Address(int addressId, String street, String houseNumber, String zipcode, String city) {
        this.addressId = addressId;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
        this.city = city;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }
}

