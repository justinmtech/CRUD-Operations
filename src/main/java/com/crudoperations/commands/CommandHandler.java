package com.crudoperations.commands;

public class CommandHandler {
    private String commandString;
    private DatabaseCommands databaseCommands;

    public CommandHandler() {
        this.databaseCommands = new DatabaseCommands();
    }

    public String getCommandString() {
        return commandString;
    }

    public void setCommandString(String commandString) {
        this.commandString = commandString;
    }


    private void createTable() {

    }

    private void createUser() {

    }

    private void deleteTable() {

    }

    private void deleteUser() {

    }

    private void replaceUser() {

    }

    private void updateUser() {

    }

    private void help() {

    }

    public void executeCommand() {
        switch (commandString) {
            case "create table":
                createTable();
                System.out.println("Table created!");
                break;
            case "delete table":
                deleteTable();
                System.out.println("Delete table!");
                break;
            case "create user":
                createUser();
                System.out.println("Create user!");
                break;
            case "replace":
                replaceUser();
                System.out.println("Replace user!");
                break;
            case "update":
                updateUser();
                System.out.println("UPdate user!");
                break;
            case "delete":
                deleteUser();
                System.out.println("DElete user!");
                break;
            case "help":
                help();
                System.out.println("Help here.");
                break;
            default:
                System.out.println("Command not recognized. Type 'help' for help.");
                break;
        }
    }


}
