// CafeApp.java
import java.util.Scanner;

public class CafeApp {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("  WELCOME TO THE CAFÉ SYSTEM ☕  ");
        System.out.println("=================================");
        
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        Order order = new Order(customer);

        // Example menu items
        Beverage coffee = new Beverage("Cappuccino", 4.50, "Medium", true);
        Pastry croissant = new Pastry("Butter Croissant", 3.00, false);
        Meal sandwich = new Meal("Club Sandwich", 7.50, true);

        // Add items to order
        order.addItem(coffee);
        order.addItem(croissant);
        order.addItem(sandwich);

        // Display Order Summary
        order.printOrderSummary();
        
        scanner.close();
    }
}
