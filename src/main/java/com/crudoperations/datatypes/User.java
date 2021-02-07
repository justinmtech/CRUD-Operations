package com.crudoperations.datatypes;

//A simple object only containing primitive data types.
public class User {
    private String username;
    private String password;
    private boolean member;

    public User(String username, String password, boolean member) {
        this.username = username;
        this.password = password;
        this.member = member;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

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
}
