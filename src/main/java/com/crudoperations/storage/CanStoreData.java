package com.crudoperations.storage;

public interface CanStoreData {
    void create();
    void read();
    void update();
    void delete();
    void createTable();
    void deleteTable();
}
