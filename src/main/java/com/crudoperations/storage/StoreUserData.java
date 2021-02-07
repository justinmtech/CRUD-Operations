package com.crudoperations.storage;

import com.crudoperations.datatypes.User;

import java.sql.*;

public class StoreUserData implements CanStoreData {
    private User user;
    private String username;
    private String password;
    private boolean member;
    private String field;
    private String value;
    private final Connection conn;
    private PreparedStatement prepStmt;
    private String query;

    public StoreUserData(String username, String password, boolean member) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        this.username = username;
        this.password = password;
        this.member = member;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost/general", "root", "41oq4ptJeBV4o1");
    }

    public StoreUserData(String username, String field, String value) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        this.username = username;
        this.field = field;
        this.value = value;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost/general", "root", "41oq4ptJeBV4o1");
    }

    public StoreUserData(String username) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        this.username = username;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost/general", "root", "41oq4ptJeBV4o1");
    }

    public StoreUserData() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost/general", "root", "41oq4ptJeBV4o1");
        user = null;
    }

    @Override
    public void create() {
        query = "INSERT INTO users(username, password, member) " + "values(?, ?, ?)";
            try {
                prepStmt = conn.prepareStatement(query);
                prepStmt.setString(1, username);
                prepStmt.setString(2, password);
                prepStmt.setBoolean(3, member);
                prepStmt.execute();
                conn.close();
                System.out.println("User data inserted successfully!");
            } catch (Exception ex) {
                System.out.println("User data not inserted!");
                System.out.println("SQLException: " + ex.getMessage());
            }
        }

    @Override
    public void read() {
        query = "SELECT * FROM users";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                String username = result.getString("username");
                boolean isMember = result.getBoolean("member");
                System.out.println(username);
                System.out.println(isMember);
            }
        } catch (SQLException ex) {
            System.out.println("Read failed.");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update() {
        try {
            switch (field) {
                case "username":
                    query = "UPDATE users SET username=? WHERE username=?";
                    prepStmt = conn.prepareStatement(query);
                    prepStmt.setString(1, value);
                    break;
                case "password":
                    query = "UPDATE users SET password=? WHERE username=?";
                    prepStmt = conn.prepareStatement(query);
                    prepStmt.setString(1, value);
                    break;
                case "membership":
                    query = "UPDATE users SET member=? WHERE username=?";
                    prepStmt = conn.prepareStatement(query);
                    boolean isMember = Boolean.getBoolean(value);
                    prepStmt.setBoolean(1, isMember);
                    break;
            }
            prepStmt.setString(2, username);
            prepStmt.execute();
            System.out.println("User update successful!");
        } catch (SQLException ex) {
            System.out.println("User update failed!");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete() {
        query = "DELETE FROM users WHERE username=?";
        try {
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, user.getUsername());
            prepStmt.execute();
            System.out.println("User deleted successfully!");

        } catch(SQLException ex) {
            System.out.println("User deletion failed!");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void createTable() {
        query = "CREATE TABLE users(" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "username VARCHAR(16) NOT NULL, " +
                "password VARCHAR(16) NOT NULL, " +
                "member TINYINT(1));";
        try {
            prepStmt = conn.prepareStatement(query);
            prepStmt.execute();
            conn.close();
            System.out.println("Table created successfully!");
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteTable() {
        query = "DROP TABLE users";
        try {
            prepStmt = conn.prepareStatement(query);
            prepStmt.execute();
            conn.close();
            System.out.println("Users table deleted!");
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
