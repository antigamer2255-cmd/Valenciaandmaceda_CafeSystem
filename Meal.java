
/**
 * Represents a rice meal in the cafe menu.
 */
public class Meal extends MenuItem {

    private boolean upsized;
    private int extraSides;

    /**
     * Default constructor.
     */
    public Meal() {
        super();
        this.upsized = false;
        this.extraSides = 0;
    }

    /**
     * Parameterized constructor.
     *
     * @param name meal name
     * @param basePrice meal base price
     * @param itemCode meal code
     * @param upsized upsize status
     * @param extraSides number of extra sides
     */
    public Meal(String name, double basePrice,
                String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    /**
     * Computes the final meal price.
     *
     * @return final meal price
     */
    @Override
    public double computePrice() {
        double price = basePrice;

        if (upsized) {
            price += 20;
        }

        price += 12 * extraSides;

        return price;
    }

    /**
     * Returns meal description.
     *
     * @return meal description
     */
    @Override
    public String getDescription() {
        String status;

        if (upsized) {
            status = "Upsized";
        } else {
            status = "Regular";
        }

        return super.getDescription()
                + " - " + status
                + " - Extra Sides: " + extraSides;
    }

    /**
     * Gets upsize status.
     *
     * @return true if upsized
     */
    public boolean isUpsized() {
        return upsized;
    }

    /**
     * Sets upsize status.
     *
     * @param upsized new upsize status
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
     * Gets number of extra sides.
     *
     * @return extra sides
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Sets number of extra sides.
     *
     * @param extraSides number of extra sides
     */
    public void setExtraSides(int extraSides) {
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            System.out.println("Error: Extra sides cannot be negative.");
        }
    }
}
