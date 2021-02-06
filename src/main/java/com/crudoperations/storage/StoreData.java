package com.crudoperations.storage;

import java.sql.DriverManager;

public class StoreData {

    public static void testConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DriverManager.getConnection("jdbc:mysql://localhost/general",
                    "root", "41oq4ptJeBV4o1");
            System.out.println("Connection successful!");
        } catch (Exception ex) {
            System.out.println("Connection failed!");
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    public void create() {

    }

    public void replace() {
        //Replace existing db entry
    }

    public void update() {
        //Update existing db entry
    }

    public void delete() {
        //Delete existing db entry
    }


}
