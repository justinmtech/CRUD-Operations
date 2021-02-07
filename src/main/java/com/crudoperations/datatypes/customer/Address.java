package com.crudoperations.datatypes.customer;

public class Address {
    public Address(String country, String state, String street, String zipCode) {
        this.country = country;
        this.state = state;
        this.street = street;
        this.zipCode = Integer.parseInt(zipCode);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    private String country;
    private String state;
    private String street;
    private int zipCode;
}
