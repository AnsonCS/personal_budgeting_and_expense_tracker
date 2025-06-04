/**
 * Represents a category under which financial transactions can be grouped.
 * 
 * Categories help in organizing transactions (e.g., "Food", "Transport", "Entertainment").
 * Each category contains a name and an optional description.
 * 
 * 
 * Example usage:
 * 
 *      Category food = new Category("Food", "Groceries and dining out");
 * 
 * 
 * Used for filtering, reporting, and budgeting within specific areas of expenditure.
 */

package main.java.com.anson.budget_tracker.model;


public class Category {
    private String name;
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    
}
