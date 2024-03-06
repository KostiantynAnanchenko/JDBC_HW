package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {

    public static void main(String[] args) {
        try {

            Class.forName("org.postgresql.Driver");


            Connection connection = Database.getInstance().getConnection();

            String sqlContent = new String(Files.readAllBytes(Paths.get("sql/init_db.sql")));

            String[] sqlQueries = sqlContent.split(";");
            for (String query : sqlQueries) {
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            }

            System.out.println("Database init successfully");

            connection.close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}