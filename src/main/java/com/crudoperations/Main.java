package com.crudoperations;

import com.crudoperations.storage.StoreData;

public class Main {

    public static void main(String args[]) throws Exception {
        StoreData db = new StoreData();
        db.testConnection();
        User user = new User("John", "", 100.00, "member");
    }
}
