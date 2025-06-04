/**
 * Manages the connection and initialization of the SQLite database.
 */

package main.java.com.anson.budget_tracker.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:budget_tracker.db";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(DB_URL);
        }
        return connection;
    }

    public static void initializeDatabase() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            // Create tables if they do not exist
            String createCategoriesTable = "CREATE TABLE IF NOT EXISTS categories (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT NOT NULL, " +
                    "description TEXT" +
                    ");";

            String createBudgetsTable = "CREATE TABLE IF NOT EXISTS budgets (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "category TEXT NOT NULL, " +
                    "`limit` REAL NOT NULL" +
                    ");";

            String createTransactionsTable = "CREATE TABLE IF NOT EXISTS transactions (" +
                    "id TEXT PRIMARY KEY, " +
                    "description TEXT NOT NULL, " +
                    "amount REAL NOT NULL, " +
                    "date DATE NOT NULL, " +
                    "time TIME NOT NULL, " +
                    "category TEXT NOT NULL, " +
                    "isIncome BOOLEAN NOT NULL" +
                    ");";

            stmt.execute(createCategoriesTable);
            stmt.execute(createBudgetsTable);
            stmt.execute(createTransactionsTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
