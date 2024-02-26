import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerAuthentication implements Authentication{
    private Connection connection;

    public ManagerAuthentication(DatabaseConnection dbManager) {
        this.connection = dbManager.getConnection();
    }
    public boolean authenticate(int user_id, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM managers WHERE manager_id = ?");
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
