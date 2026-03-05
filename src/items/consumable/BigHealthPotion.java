package items.consumable;
/**
 * Represents a big health potion.
 * <p>
 * The BigHealthPotion is a consumable item that provides
 * a fixed healing effect of 5 points to a character.
 * </p>
 */
public class BigHealthPotion extends Consumable{

    /**
     * Creates a new BigHealthPotion with a fixed healing value of 5.
     */
    public BigHealthPotion() {
        super(5);
    }
    /**
     * Returns a string representation of the BigHealthPotion.
     *
     * @return a string containing the healing effect
     */
    @Override
    public String toString() {
        return "BigHealthPotion {Soin =" + healing + "}";
    }
}