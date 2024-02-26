import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Manager extends User{
    private final Connection connection;

    public Manager(int id, DatabaseConnection connection){
        super(id);
        this.connection = connection.getConnection();
    }


    public String get_name(int id){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT manager_name FROM managers WHERE manager_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("manager_name");
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
