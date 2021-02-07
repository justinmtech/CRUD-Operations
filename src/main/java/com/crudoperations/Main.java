package com.crudoperations;

import com.crudoperations.commands.UserCommandHandler;

public class Main {
    private static boolean running = true;

    public static void main(String args[]) throws Exception {
        UserCommandHandler cmdListener = new UserCommandHandler();
        while (running) {
        cmdListener.listenToCommand();
        }
    }
}
