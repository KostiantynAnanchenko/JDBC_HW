package Tasks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
    public static void main(String[] args) {
        Database database = Database.getInstance();

        try (Connection connection = database.getConnection()) {
            if (connection != null) {
                System.out.println("Connected to the database!");

            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}