
/**
 * Represents a pastry in the cafe menu.
 */
public class Pastry extends MenuItem {

    private boolean warmed;

    /**
     * Default constructor.
     */
    public Pastry() {
        super();
        this.warmed = false;
    }

    /**
     * Parameterized constructor.
     *
     * @param name pastry name
     * @param basePrice pastry base price
     * @param itemCode pastry code
     * @param warmed warming status
     */
    public Pastry(String name, double basePrice,
                  String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes pastry price.
     *
     * @return final pastry price
     */
    @Override
    public double computePrice() {
        double price = basePrice;

        if (warmed) {
            price += 10;
        }

        return price;
    }

    /**
     * Returns pastry description.
     *
     * @return pastry description
     */
    @Override
    public String getDescription() {
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }

        return super.getDescription();
    }

    /**
     * Checks if pastry is warmed.
     *
     * @return true if warmed
     */
    public boolean isWarmed() {
        return warmed;
    }

    /**
     * Sets warming status.
     *
     * @param warmed warming status
     */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
