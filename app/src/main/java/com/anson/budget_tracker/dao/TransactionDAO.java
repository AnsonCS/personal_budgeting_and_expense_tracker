package main.java.com.anson.budget_tracker.dao;

import main.java.com.anson.budget_tracker.model.Transaction;
import main.java.com.anson.budget_tracker.database.DatabaseManager;

import java.sql.*;
import java.time.*;
import java.util.*;
/**
 * Handles CRUD operations for Transaction objects in the database.
 */
public class TransactionDAO {
    public void saveTransaction(Transaction tx) {
        String sql = "INSERT INTO transactions(id, description, category, amount, date, time, isIncome) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tx.getId());
            pstmt.setString(2, tx.getDescription());
            pstmt.setString(3, tx.getCategory());
            pstmt.setDouble(4, tx.getAmount());
            pstmt.setString(5, tx.getDate().toString());
            pstmt.setString(6, tx.getTime().toString()); // or store current time
            pstmt.setBoolean(7, tx.isIncome());

            pstmt.executeUpdate();
            System.out.println("Transaction saved: " + tx.getDescription());
        } catch (SQLException e) {
            System.err.println("Failed to save transaction: " + e.getMessage());
        }
    }

      /**
     * Retrieves all transactions from the database.
     *
     * @return a list of all Transaction objects
     */
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Transaction tx = new Transaction(
                        rs.getString("id"),
                        rs.getString("description"),
                        rs.getDouble("amount"),
                        LocalDate.parse(rs.getString("date")),
                        LocalTime.parse(rs.getString("time")),
                        rs.getString("category"),
                        rs.getInt("isIncome") == 1
                );
                transactions.add(tx);
            }

        } catch (SQLException e) {
            System.err.println("Failed to retrieve transactions: " + e.getMessage());
        }

        return transactions;
    }
}
