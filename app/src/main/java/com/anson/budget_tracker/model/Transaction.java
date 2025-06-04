/**
 * Represents a single financial transaction, either an income or an expense.
 * 
 * Each transaction includes details such as description, amount, date,
 * associated category, and whether it is an income or expense.
 * 
 * 
 * Example usage:
 * 
 *      Transaction t = new Transaction("1", "Salary", 5000.00, LocalDate.now(), "Income", true);
 * 
 * 
 * This class is central to tracking the flow of money in the budgeting application.
 */

package main.java.com.anson.budget_tracker.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Transaction {
    private String id;
    private String description;
    private double amount;
    private LocalDate date;
    private LocalTime time;
    private String category;
    private boolean isIncome;

    public Transaction(String id, String description, double amount, LocalDate date, LocalTime time, String category, boolean isIncome) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.time = time;
        this.category = category;
        this.isIncome = isIncome;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public LocalTime getTime() { return time.truncatedTo(ChronoUnit.MINUTES); }
    public LocalDate getDate() { return date; }
    public String getCategory() { return category; }
    public boolean isIncome() { return isIncome; }

    @Override
    public String toString() {
        return (isIncome ? "[INCOME] " : "[EXPENSE] ") + description + " - " + amount + " (" + category + ") on " + date + " " + time.truncatedTo(ChronoUnit.MINUTES);
    }
}
