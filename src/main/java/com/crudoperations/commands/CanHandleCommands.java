package com.crudoperations.commands;

public interface CanHandleCommands {

    String getInput(String question);
    void listenToCommand();
    void processInput();
    void create();
    void read();
    void update();
    void delete();
    void help();
    void quit();
    void createTable();
    void deleteTable();
}
