import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends User{
    private final Connection connection;
    public Customer(int id, DatabaseConnection connection){
        super(id);
        this.connection = connection.getConnection();
    }

    public String get_name(int id){
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT customer_name FROM customers WHERE customer_id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                return resultSet.getString("customer_name");
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
