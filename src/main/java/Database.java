import java.sql.DriverManager;

public class Database {

    public static void testConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DriverManager.getConnection("jdbc:mysql://localhost/database", "root", "password");
        } catch (Exception ex) {
            System.out.println("Connection failed!");
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    public void create() {
        //Create new db entry
    }

    public void replace() {
        //Replace existing db entry
    }

    public void update() {
        //Update existing db entry
    }

    public void delete() {
        //Delete existing db entry
    }
}
