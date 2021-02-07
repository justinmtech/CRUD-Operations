package com.crudoperations.commands;

import com.crudoperations.datatypes.player.Location;
import com.crudoperations.storage.CanStoreData;
import com.crudoperations.storage.StoreCustomerData;
import com.crudoperations.storage.StoreUserData;
import com.crudoperations.datatypes.customer.Address;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerCommandHandler implements CanHandleCommands{
    private final Scanner scanner;
    private String input;
    private CanStoreData storeData;


    public CustomerCommandHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String getInput(String question) {
        System.out.println(question + ": ");
        input = scanner.nextLine();
        return input;
    }

    @Override
    public void listenToCommand() {
        System.out.println("Enter command: ");
        input = scanner.nextLine();
        processInput();
    }

    public void processInput() {
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

    public void create() {
        boolean userCreated = false;

        while (!userCreated) {
            System.out.println("Enter the information prompted to create new Customer.");
            String username = getInput("Username");
            String password = getInput("Password");
            String country = getInput("Country");
            String state = getInput("State");
            String street = getInput("Street");
            String zipCode = getInput("Zip Code");
            storeData = new StoreCustomerData(username, password, new Address(country, state, street, zipCode), null);
            storeData.create();
            userCreated = true;
        }
    }

    public void read() {
        storeData = new StoreUserData();
        storeData.read();
    }

    public void update() {
        System.out.println("Enter the user you would like to update: ");
        String username = getInput("Username");
        System.out.println("What would you like to update (Username, Password, Membership)?");
        String field = getInput("Update Information");
        String value = getInput("Enter the new " + field);
        storeData = new StoreUserData(username, field, value);
        storeData.update();
    }

    public void delete() {
        String username = getInput("Enter the user you want to delete: ");
        storeData = new StoreUserData(username);
        storeData.delete();
    }

    public void help() {
        System.out.println("Command list:");
        System.out.println("- Create");
        System.out.println("- Read");
        System.out.println("- Update");
        System.out.println("- Delete");
        System.out.println("- Help");
    }

    public void quit() {
        System.out.println("Quit successfully.");
    }

    public void createTable() {
        storeData = new StoreUserData();
        storeData.createTable();
    }

    public void deleteTable() {
        storeData = new StoreUserData();
        storeData.deleteTable();
    }
}
