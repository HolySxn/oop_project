import java.util.ArrayList;
import java.util.List;
import java.sql.*;
// import java.sql.DriverManager;

class Library {
    static final String URL = "jdbc:postgresql://localhost:5432/library";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "123";
    private Connection connection;

    // private List<Item> items;

    public Library() {
        // this.items = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;

    }

    public void addItem(int id, String name, int year, String author) {
        // items.add(item);
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO books (book_id, book_name, year_of_publ, author)" +
                            "VALUES (?, ?, ?, ?)");
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, year);
            statement.setString(4, author);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public void removeItem(int id) {
//        items.removeIf(item -> item.id == id);
//    }
//
//    public void borrowItem(String title) {
//        for (Item item : items) {
//            if (item instanceof Book && item.name.equals(title) && ((Book) item).isAvailable()) {
//                ((Book) item).setAvailable(false);
//                System.out.println("Book '" + title + "' borrowed successfully.");
//                return;
//            }
//        }
//        System.out.println("Book '" + title + "' not available for borrowing.");
//    }
//
//    public void returnItem(String title) {
//        for (Item item : items) {
//            if (item instanceof Book && item.name.equals(title) && !((Book) item).isAvailable()) {
//                ((Book) item).setAvailable(true);
//                System.out.println("Book '" + title + "' returned successfully.");
//                return;
//            }
//        }
//        System.out.println("Book '" + title + "' not found or already returned.");
//    }
//
//    public void displayAvailableItems() {
//        System.out.println("Available Items:");
//        for (Item item : items) {
//            if (item instanceof Book && ((Book) item).isAvailable()) {
//                item.displayDetails();
//            }
//        }
//    }
//
//    public List<Item> getItems() {
//        return items;
//    }
}
