
/**
 * Represents a beverage in the cafe menu.
 */
public class Beverage extends MenuItem {

    private String size;

    /**
     * Default constructor.
     */
    public Beverage() {
        super();
        this.size = "S";
    }

    /**
     * Parameterized constructor.
     *
     * @param name beverage name
     * @param basePrice beverage base price
     * @param itemCode beverage code
     * @param size beverage size
     */
    public Beverage(String name, double basePrice,
                    String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }

    /**
     * Computes the beverage price based on size.
     *
     * @return final beverage price
     */
    @Override
    public double computePrice() {
        double price = basePrice;

        if (size.equals("S")) {
            price = basePrice;
        } else if (size.equals("M")) {
            price = basePrice + 15;
        } else if (size.equals("L")) {
            price = basePrice + 25;
        }

        return price;
    }

    /**
     * Returns beverage description.
     *
     * @return description with size
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " - Size: " + size;
    }

    /**
     * Gets beverage size.
     *
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     * Sets beverage size.
     *
     * @param size S, M, or L
     */
    public void setSize(String size) {
        if (size != null &&
            (size.equals("S") || size.equals("M") || size.equals("L"))) {
            this.size = size;
        } else {
            System.out.println("Error: Size must be S, M, or L.");
        }
    }
}
