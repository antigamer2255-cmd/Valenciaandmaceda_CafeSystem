
/**
 * Main class for the Campus Café Ordering System.
 */
public class CafeApp {

    /**
     * Runs the café application.
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("CAMPUS CAFE ORDERING SYSTEM");

        // Create customers using different constructors.
        Customer customer1 =
                new Customer("Jan Clarence Valencia", true);

        Customer customer2 =
                new Customer("Dennis Valerian Maceda");

        Customer customer3 = new Customer();

        // Create Beverage using default constructor.
        Beverage beverage1 = new Beverage();
        beverage1.setName("Iced Coffee");
        beverage1.setBasePrice(50);
        beverage1.setItemCode("B001");
        beverage1.setSize("M");

        // Create Beverage using parameterized constructor.
        Beverage beverage2 =
                new Beverage("Milk Tea", 60, "B002", "L");

        // Create Pastry using default constructor.
        Pastry pastry1 = new Pastry();
        pastry1.setName("Chocolate Muffin");
        pastry1.setBasePrice(35);
        pastry1.setItemCode("P001");
        pastry1.setWarmed(true);

        // Create Pastry using parameterized constructor.
        Pastry pastry2 =
                new Pastry("Cheese Bread", 25, "P002", false);

        // Create Meal using default constructor.
        Meal meal1 = new Meal();
        meal1.setName("Chicken Rice Meal");
        meal1.setBasePrice(100);
        meal1.setItemCode("M001");
        meal1.setUpsized(true);
        meal1.setExtraSides(2);

        // Create Meal using parameterized constructor.
        Meal meal2 =
                new Meal("Pork Sisig Rice", 120, "M002", false, 1);

        // Test invalid setters.
        System.out.println("\n--- INVALID DATA TEST ---");
        beverage1.setSize("XL");
        pastry1.setBasePrice(-50);
        meal1.setExtraSides(-2);

        // FIRST ORDER.
        System.out.println("\n--- ORDER 1 ---");

        Order order1 = new Order("ORD-001", customer1);

        order1.addItem(beverage1);
        order1.addItem(pastry1);
        order1.addItem(meal1);

        // Attempt to add a fourth item.
        System.out.println("\nTesting fourth item:");
        order1.addItem(beverage2);

        order1.printReceipt();

        // SECOND ORDER.
        System.out.println("\n--- ORDER 2 ---");

        Order order2 = new Order("ORD-002", customer2);

        order2.addItem(beverage2);
        order2.addItem(pastry2);
        order2.addItem(meal2);

        order2.printReceipt();

        // Test overloaded computeTotal method.
        System.out.println("\n--- VOUCHER TEST ---");

        System.out.printf(
                "Order 2 with P20 voucher: P%.2f%n",
                order2.computeTotal(20)
        );

        // Display customer information.
        System.out.println("\n--- CUSTOMER INFORMATION ---");

        System.out.println("Customer: " + customer1.getName());
        System.out.println("Points: " + customer1.getLoyaltyPoints());

        System.out.println("Customer: " + customer2.getName());
        System.out.println("Points: " + customer2.getLoyaltyPoints());

        System.out.println("Default Customer: " + customer3.getName());

        System.out.println("\nPROGRAM COMPLETED!");
    }
}
