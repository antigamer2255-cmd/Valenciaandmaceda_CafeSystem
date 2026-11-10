
/**
 * Represents a cafe order containing up to three menu items.
 */
public class Order {

    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    private boolean pointsAwarded;

    /**
     * Creates an order for a customer.
     *
     * @param orderId order identification
     * @param customer customer placing the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.item1 = null;
        this.item2 = null;
        this.item3 = null;
        this.itemCount = 0;
        this.pointsAwarded = false;
    }

    /**
     * Adds an item to the order.
     *
     * @param item menu item to add
     * @return true if successfully added
     */
    public boolean addItem(MenuItem item) {

        if (item == null) {
            System.out.println("Error: Cannot add an empty item.");
            return false;
        }

        if (itemCount >= 3) {
            System.out.println("Order limit reached! Only 3 items allowed.");
            return false;
        }

        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else if (item3 == null) {
            item3 = item;
        }

        itemCount++;

        System.out.println(item.getName() + " added successfully!");

        return true;
    }

    /**
     * Computes subtotal using polymorphism.
     *
     * @return subtotal
     */
    public double computeSubtotal() {
        double subtotal = 0;

        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    /**
     * Computes total with student discount.
     *
     * @return final total
     */
    public double computeTotal() {
        double subtotal = computeSubtotal();

        if (customer.isStudent()) {
            return subtotal - (subtotal * 0.10);
        }

        return subtotal;
    }

    /**
     * Computes total with student discount and voucher.
     *
     * @param voucher voucher amount
     * @return final total
     */
    public double computeTotal(double voucher) {
        if (voucher < 0) {
            System.out.println("Invalid voucher. Using zero.");
            voucher = 0;
        }

        double total = computeTotal() - voucher;

        if (total < 0) {
            total = 0;
        }

        return total;
    }

    /**
     * Prints the order receipt and updates loyalty points.
     */
    public void printReceipt() {

        double subtotal = computeSubtotal();
        double total = computeTotal();
        double discount = subtotal - total;

        System.out.println("\n==================================");
        System.out.println("       CAMPUS CAFE RECEIPT");
        System.out.println("==================================");

        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getName());

        if (customer.isStudent()) {
            System.out.println("Customer Type: Student");
        } else {
            System.out.println("Customer Type: Regular");
        }

        System.out.println("----------------------------------");

        if (item1 != null) {
            System.out.printf("%-25s ₱%.2f%n",
                    item1.getDescription(), item1.computePrice());
        }

        if (item2 != null) {
            System.out.printf("%-25s ₱%.2f%n",
                    item2.getDescription(), item2.computePrice());
        }

        if (item3 != null) {
            System.out.printf("%-25s ₱%.2f%n",
                    item3.getDescription(), item3.computePrice());
        }

        System.out.println("----------------------------------");

        System.out.printf("Subtotal:       ₱%.2f%n", subtotal);
        System.out.printf("Discount:       ₱%.2f%n", discount);
        System.out.printf("Total:          ₱%.2f%n", total);

        if (!pointsAwarded) {
            customer.addPoints(total);
            pointsAwarded = true;
        }

        System.out.println("----------------------------------");
        System.out.println("Loyalty Points: "
                + customer.getLoyaltyPoints());

        System.out.println("==================================");
        System.out.println("       THANK YOU! COME AGAIN!");
        System.out.println("==================================");
    }
}
