package items.offensiveEquipment.spell;

import characters.Character;
import characters.Wizard;
import items.offensiveEquipment.OffensiveEquipment;
/**
 * Represents a Spell as an offensive equipment.
 * <p>
 * A Spell provides an attack bonus and can only be equipped
 * by {@link Wizard} characters.
 * </p>
 */
public class Spell extends OffensiveEquipment {
    /**
     * Creates a new Spell with the specified attack bonus.
     *
     * @param attackBonus the attack bonus of the spell
     */
    public Spell(int attackBonus) {
        super(attackBonus);
    }
    /**
     * Checks whether the spell can be equipped by the given character.
     * <p>
     * Only {@link Wizard} characters can equip a Spell.
     * </p>
     *
     * @param character the character to check compatibility with
     * @return {@code true} if the character is a Wizard, {@code false} otherwise
     */
    @Override
    public boolean isCompatibleWith(Character character) {
        return character instanceof Wizard;
    }
    /**
     * Returns a string representation of the spell.
     *
     * @return a string containing the attack bonus
     */
    @Override
    public String toString() {
        return "Spell {Bonus d'attaque=" + attackBonus + "}";
    }
}