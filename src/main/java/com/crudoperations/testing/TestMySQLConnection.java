package com.crudoperations.testing;

import com.crudoperations.storage.CanConnectStorage;

import java.sql.DriverManager;

public class TestMySQLConnection implements CanConnectStorage {

    @Override
    public void tryConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DriverManager.getConnection("jdbc:mysql://localhost/general",
                    "root", "41oq4ptJeBV4o1");
            System.out.println("MySQL connection successful!");
        } catch (Exception ex) {
            System.out.println("Connection failed!");
            System.out.println("SQLException: " + ex.getMessage());
        }
    }
}
