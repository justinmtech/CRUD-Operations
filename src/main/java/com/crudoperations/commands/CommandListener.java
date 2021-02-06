package com.crudoperations.commands;

import com.crudoperations.commands.CommandHandler;

import java.util.Scanner;

public class CommandListener {
    private CommandHandler cmdHandler;
    private boolean running;
    private Scanner scanner;
    private String input;
    private boolean commandExists;


    public CommandListener() {
        this.running = true;
        this.scanner = new Scanner(System.in);
        this.cmdHandler = new CommandHandler();
        commandExists = false;
    }

    public void listenToInput() {
        while (running) {
            System.out.println("Enter command: ");
            input = scanner.next();
            commandExists();
            if (commandExists) {
                cmdHandler.setCommandString(input);
                cmdHandler.executeCommand();
            } else {
                System.out.println("Command not found. Type 'help' for help.");
            }
        }
    }

    public boolean commandExists() {
        switch (input) {
            case "create":
            case "replace":
            case "update":
            case "delete":
            case "help":
                commandExists = true;
                break;
        }
        return commandExists;
    }

}
