package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {

    public static void main(String[] args) {
        String populateScriptPath = "sql/populate_db.sql";

        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();

            String sqlScript = new String(Files.readAllBytes(Paths.get(populateScriptPath)));
            String[] sqlCommands = sqlScript.split(";");

            for (String command : sqlCommands) {
                statement.executeUpdate(command);
            }

            System.out.println("Database populated successfully.");


            statement.close();
            connection.close();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}