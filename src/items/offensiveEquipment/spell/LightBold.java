package items.offensiveEquipment.spell;

import items.offensiveEquipment.spell.Spell;
/**
 * Represents the LightBold spell.
 * <p>
 * LightBold is a specific type of {@link Spell} with a fixed attack bonus of 2.
 * It can only be equipped by {@link characters.Wizard} characters.
 * </p>
 */
public class LightBold extends Spell {
    /**
     * Creates a new LightBold spell with a default attack bonus of 2.
     */
    public LightBold() {
        super(2);
    }
    /**
     * Returns a string representation of the LightBold spell.
     *
     * @return a string containing the attack bonus
     */
    @Override
    public String toString() {
        return "LightBold {Bonus d'attaque=" + attackBonus + "}";
    }
}