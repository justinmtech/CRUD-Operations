package com.crudoperations;

import com.crudoperations.commands.CommandHandler;

public class Main {
    private static boolean running = true;

    public static void main(String args[]) throws Exception {
        CommandHandler cmdListener = new CommandHandler();
        while (running) {
        cmdListener.listenToCommand();
        }
    }
}
