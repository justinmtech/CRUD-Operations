package com.crudoperations.datatypes.player;

public class Inventory {
    private String[] inventory;

    public Inventory(String[] inventory) {
        this.inventory = inventory;
    }

    public Inventory() {
        this.inventory = new String[]{"", "", "", "", ""};
    }

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }



}
