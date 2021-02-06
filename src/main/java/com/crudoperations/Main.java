package com.crudoperations;

import com.crudoperations.storagetest.TestMariaDBConnection;
import com.crudoperations.storage.*;

public class Main {

    public static void main(String args[]) throws Exception {
        CanStoreData storeData = new StoreEmployeeData();
        CanConnectStorage testStorage = new TestMariaDBConnection();

        testStorage.tryConnection();
        storeData.create();
    }
}
