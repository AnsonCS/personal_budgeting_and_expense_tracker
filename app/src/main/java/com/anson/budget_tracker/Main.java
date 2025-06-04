package com.anson.budget_tracker;

import com.anson.budget_tracker.*;
import main.java.com.anson.budget_tracker.dao.TransactionDAO;
import main.java.com.anson.budget_tracker.database.DatabaseManager;
import main.java.com.anson.budget_tracker.model.Transaction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.initializeDatabase();

        Transaction tx = new Transaction(
                UUID.randomUUID().toString(),
                "Spotify Subscription",
                100.00,
                LocalDate.now(),
                LocalTime.now(),
                "Entertainment",
                false
        );

        TransactionDAO dao = new TransactionDAO();
        dao.saveTransaction(tx);
    }  
}
