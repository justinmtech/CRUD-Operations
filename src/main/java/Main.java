public class Main {

    public static void main(String args[]) throws Exception {
        Database db = new Database();
        db.testConnection();
        User user = new User("John", "", 100.00, "member");
    }
}
