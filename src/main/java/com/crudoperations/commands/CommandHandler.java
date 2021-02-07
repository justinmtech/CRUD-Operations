package com.crudoperations.commands;

import com.crudoperations.storage.CanStoreData;
import com.crudoperations.storage.StoreUserData;

import java.sql.SQLException;
import java.util.Scanner;

public class CommandHandler {
    private final Scanner scanner;
    private String input;
    private CanStoreData storeData;


    public CommandHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput(String question) {
        System.out.println(question + ": ");
        input = scanner.nextLine();
        return input;
    }

    public void listenToCommand() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
            System.out.println("Enter command: ");
            input = scanner.nextLine();
            processInput();
    }

    private void processInput() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        switch (input) {
            case "create":
                create();
                break;
            case "read":
                read();
                break;
            case "update":
                update();
                break;
            case "delete":
                delete();
                break;
            case "help":
                help();
                break;
            case "quit":
                quit();
                break;
            case "create table":
                createTable();
                break;
            case "delete table":
                deleteTable();
                break;
            default:
                System.out.println("Command not found. Type 'help' for help.");
        }
    }

    private void create() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        boolean userCreated = false;

        while (!userCreated) {
            System.out.println("Enter the information prompted to create new User.");
            String username = getInput("Username");
            String password = getInput("Password");
            String memberInput = getInput("Member (True/False)");
            boolean isMember = Boolean.parseBoolean(memberInput);

            storeData = new StoreUserData(username, password, isMember);
            storeData.create();
            userCreated = true;
        }
    }

    private void read() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        storeData = new StoreUserData();
        storeData.read();
    }

    private void update() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
            System.out.println("Enter the user you would like to update: ");
            String username = getInput("Username");
            System.out.println("What would you like to update (Username, Password, Membership)?");
            String field = getInput("Update Information");
            String value = getInput("Enter the new " + field);

            storeData = new StoreUserData(username, field, value);
            storeData.update();

    }

    private void delete() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        String username = getInput("Enter the user you want to delete: ");
        storeData = new StoreUserData(username);
        storeData.delete();
    }

    private void help() {
        System.out.println("Command list:");
        System.out.println("- Create");
        System.out.println("- Read");
        System.out.println("- Update");
        System.out.println("- Delete");
        System.out.println("- Help");
    }

    private void quit() {
        System.out.println("Quit successfully.");
    }

    private void createTable() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        storeData = new StoreUserData();
        storeData.createTable();
    }

    private void deleteTable() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        storeData = new StoreUserData();
        storeData.deleteTable();
    }
}
