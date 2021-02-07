package com.crudoperations.datatypes.player;

//A more complicated object with states that reference other objects.
public class Player {
    private String password;
    private boolean member;
    private double money;
    private Inventory inventory;
    private Location location;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public Player(String username, String password, boolean member, double money, Inventory inventory, Location location) {
        this.username = username;
        this.password = password;
        this.member = member;
        this.money = money;
        this.inventory = inventory;
        this.location = location;
    }

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.member = false;
        this.money = 0;
        this.inventory = new Inventory();
        this.location = new Location();
    }
}
