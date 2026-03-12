package items.consumable;
/**
 * Represents a consumable item.
 * <p>
 * Consumables provide a healing effect to characters.
 * Subclasses can define specific types of consumables with different healing values.
 * </p>
 */
public abstract class Consumable {
    /** Healing effect provided by the consumable */
    protected int healing;

    //constructeur
    /**
     * Creates a new consumable with the specified healing value.
     *
     * @param healing the healing amount provided by the consumable
     */
    public Consumable(int healing) {
        this.healing = healing;
    }

    //getters et setter
    /**
     * Returns the healing value of the consumable.
     *
     * @return the healing value
     */
    public int getHealing() {
        return healing;
    }
    /**
     * Sets a new healing value for the consumable.
     *
     * @param healing the new healing amount
     */
    public void setHealing(int healing){
        this.healing = healing;
    }

    public abstract String getAsciiArt();
    /**
     * Returns a string representation of the consumable.
     *
     * @return a string containing the healing effect
     */
    @Override
    public String toString() {
        return "Effet de soin : " + healing;
    }
}
