package exercicioCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author camilla
 */
public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/ejerciciocrud";
    private static final String USER = "root";
    private static final String PASSWORD = "pindamonhangaba";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}