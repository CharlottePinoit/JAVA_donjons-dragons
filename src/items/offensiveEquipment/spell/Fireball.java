package items.offensiveEquipment.spell;

import characters.Wizard;
import items.offensiveEquipment.spell.Spell;
/**
 * Represents the Fireball spell.
 * <p>
 * Fireball is a specific type of {@link Spell} with a fixed attack bonus of 7.
 * It can only be equipped by {@link characters.Wizard} characters.
 * </p>
 */
public class Fireball extends Spell {
    /**
     * Creates a new Fireball spell with a default attack bonus of 7.
     */
    public Fireball() {
        super(7, "boule de feu");
    }
    /**
     * Returns a string representation of the Fireball spell.
     *
     * @return a string containing the attack bonus
     */
    @Override
    public boolean isCompatibleWith(characters.Character character) {
        return character instanceof Wizard;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}