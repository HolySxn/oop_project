import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerAuthentication {
    private final Connection connection;

    public CustomerAuthentication(DatabaseConnection dbManager) {
        this.connection = dbManager.getConnection();
    }

    public boolean authenticate(int user_id, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM customers WHERE customer_id = ?");
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String user_password = resultSet.getString("password");

                return user_password.equals(password);
            }
            else {
                System.out.println("Incorrect id or password");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
