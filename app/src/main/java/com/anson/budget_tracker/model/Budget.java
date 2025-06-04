/**
 * Represents a spending limit for a specific category.
 * 
 * A Budget object defines how much can be spent within a category before it is considered
 * over-budget. This class supports financial discipline by restricting spending.
 * 
 * 
 * Example usage:
 * 
 *      Budget foodBudget = new Budget("Food", 2000.00);
 * 
 * 
 * Can be used to alert the user when spending exceeds the predefined limit.
 */

package main.java.com.anson.budget_tracker.model;

public class Budget {
    private String category;
    private double limit;

    public Budget(String category, double limit) {
        this.category = category;
        this.limit = limit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "category='" + category + '\'' +
                ", limit=" + limit +
                '}';
    }
}
