package items.offensiveEquipment.weapon;

import characters.Warrior;

/**
 * Represents a Mace weapon.
 * <p>
 * The Mace is a specific type of {@link Weapon} with a fixed attack bonus of 3.
 * It can only be equipped by {@link characters.Warrior} characters.
 * </p>
 */
public class Mace extends Weapon {

    /**
     * Creates a new Mace with a default attack bonus of 3.
     */
    public Mace() {
        super(3, "Massue");
    }
    @Override
    public boolean isCompatibleWith(characters.Character character) {
        return character instanceof Warrior;
    }

    /**
     * Returns a string representation of the Mace.
     *
     * @return a string containing the attack bonus
     */
    @Override
    public String toString() {
        return super.toString(); // Utilise la méthode toString() de Weapon
    }
}