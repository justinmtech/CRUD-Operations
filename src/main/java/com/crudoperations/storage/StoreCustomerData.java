package com.crudoperations.storage;

import com.crudoperations.datatypes.customer.Address;
import com.crudoperations.datatypes.customer.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoreCustomerData implements CanStoreData {
    private String username;
    private String password;
    private Address address;
    private ArrayList<Product> purchasedProducts;
    private Connection conn;
    private PreparedStatement prepStmt;
    private String query;


    public StoreCustomerData(String username, String password, Address address, ArrayList<Product> purchasedProducts) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.purchasedProducts = purchasedProducts;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/general", "root", "41oq4ptJeBV4o1");
        } catch(SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void create() {
        query = "INSERT INTO customers(username, password) " + "values(?, ?)";
        try {
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, username);
            prepStmt.setString(2, password);
            prepStmt.execute();




            conn.close();
            System.out.println("User data inserted successfully!");
        } catch (Exception ex) {
            System.out.println("User data not inserted!");
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void createTable() {

    }

    @Override
    public void deleteTable() {

    }
}
