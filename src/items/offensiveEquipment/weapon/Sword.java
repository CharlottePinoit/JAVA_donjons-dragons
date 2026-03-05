package items.offensiveEquipment.weapon;

/**
 * Represents a Sword weapon.
 * <p>
 * The Sword is a specific type of {@link Weapon} with a fixed attack bonus of 5.
 * It can only be equipped by {@link characters.Warrior} characters.
 * </p>
 */
public class Sword extends Weapon {

    /**
     * Creates a new Sword with a default attack bonus of 5.
     */
    public Sword() {
        super(5);
    }

    /**
     * Returns a string representation of the Sword.
     *
     * @return a string containing the attack bonus
     */
    @Override
    public String toString() {
        return "Sword {Attack Bonus=" + attackBonus + "}";
    }
}