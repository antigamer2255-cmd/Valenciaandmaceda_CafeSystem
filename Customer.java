
/**
 * Represents a customer of the campus cafe.
 */
public class Customer {

    private String name;
    private boolean student;
    private int loyaltyPoints;

    /**
     * Default constructor.
     */
    public Customer() {
        this.name = "Unknown Customer";
        this.student = false;
        this.loyaltyPoints = 0;
    }

    /**
     * Constructor with customer name.
     *
     * @param name customer name
     */
    public Customer(String name) {
        this(name, false);
    }

    /**
     * Constructor with customer name and student status.
     *
     * @param name customer name
     * @param student student status
     */
    public Customer(String name, boolean student) {
        this.name = "Unknown Customer";
        setName(name);
        this.student = student;
        this.loyaltyPoints = 0;
    }

    /**
     * Adds loyalty points directly.
     *
     * @param points points to add
     */
    public void addPoints(int points) {
        if (points >= 0) {
            loyaltyPoints += points;
        } else {
            System.out.println("Error: Points cannot be negative.");
        }
    }

    /**
     * Adds one loyalty point for every 50 pesos spent.
     *
     * @param amountSpent total amount spent
     */
    public void addPoints(double amountSpent) {
        if (amountSpent >= 0) {
            loyaltyPoints += (int) (amountSpent / 50);
        } else {
            System.out.println("Error: Amount cannot be negative.");
        }
    }

    /**
     * Gets customer name.
     *
     * @return customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets customer name.
     *
     * @param name customer name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Invalid customer name.");
        }
    }

    /**
     * Checks if customer is a student.
     *
     * @return true if student
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * Sets student status.
     *
     * @param student student status
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
     * Gets loyalty points.
     *
     * @return current loyalty points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets loyalty points.
     *
     * @param loyaltyPoints new loyalty points
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Error: Loyalty points cannot be negative.");
        }
    }
}
