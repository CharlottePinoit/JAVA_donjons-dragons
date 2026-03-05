package items.consumable;
/**
 * Represents a small health potion.
 * <p>
 * The SmallHealthPotion is a consumable item that provides
 * a fixed healing effect of 2 points to a character.
 * </p>
 */
public class SmallHealthPotion extends Consumable{
    /**
     * Creates a new SmallHealthPotion with a fixed healing value of 2.
     */
    public SmallHealthPotion() {
        super(2);
    }
    /**
     * Returns a string representation of the SmallHealthPotion.
     *
     * @return a string containing the healing effect
     */
    @Override
    public String toString() {
        return "SmallHealthPotion {Soin =" + healing + "}";
    }
}

