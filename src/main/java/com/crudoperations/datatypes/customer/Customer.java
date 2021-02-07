package com.crudoperations.datatypes.customer;

import java.util.ArrayList;

public class Customer {
    private String password;
    private Address address;
    private ArrayList<Product> purchasedProducts;
    private String username;

    public Customer(String username, String password, Address address, ArrayList<Product> purchasedProducts) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.purchasedProducts = purchasedProducts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
}
