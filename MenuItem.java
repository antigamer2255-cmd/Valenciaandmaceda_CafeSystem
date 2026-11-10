
/**
 * Abstract parent class for all cafe menu items.
 */
public abstract class MenuItem {

    protected String name;
    protected double basePrice;
    private String itemCode;

    /**
     * Default constructor.
     */
    public MenuItem() {
        this.name = "Unnamed Item";
        this.basePrice = 0.0;
        this.itemCode = "N/A";
    }

    /**
     * Parameterized constructor.
     *
     * @param name item name
     * @param basePrice item base price
     * @param itemCode item code
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
    }

    /**
     * Calculates the final price of the menu item.
     *
     * @return computed price
     */
    public abstract double computePrice();

    /**
     * Returns the item description.
     *
     * @return item name and code
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * Gets the item name.
     *
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the item name.
     *
     * @param name new item name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Invalid item name.");
        }
    }

    /**
     * Gets the base price.
     *
     * @return base price
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price.
     *
     * @param basePrice new base price
     */
    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            System.out.println("Error: Price cannot be negative.");
        }
    }

    /**
     * Gets the item code.
     *
     * @return item code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets the item code.
     *
     * @param itemCode new item code
     */
    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        } else {
            System.out.println("Error: Invalid item code.");
        }
    }
}
