package items.offensiveEquipment.weapon;
import characters.Character;
import characters.Warrior;
import items.offensiveEquipment.OffensiveEquipment;
/**
 * Represents a weapon that can be equipped by a character.
 * <p>
 * A weapon provides an attack bonus and is only compatible with {@link Warrior} characters.
 * </p>
 */
public class Weapon extends OffensiveEquipment {
    /**
     * Creates a new weapon with the specified attack bonus.
     *
     * @param attackBonus the attack bonus of the weapon
     */
    public Weapon(int attackBonus, String name) {

        super(attackBonus, name);
    }

    /**
     * Checks whether the weapon can be equipped by the given character.
     * <p>
     * Only {@link Warrior} characters can equip a weapon.
     * </p>
     *
     * @param character the character to check compatibility with
     * @return {@code true} if the character is a Warrior, {@code false} otherwise
     */
    @Override
    public boolean isCompatibleWith(Character character) {
        return character instanceof Warrior;
    }

    /**
     * Returns a string representation of the weapon.
     *
     * @return a string containing the attack bonus
     */
    @Override
    public String toString() {
        return name + " {Bonus d'attaque=" + attackBonus + "}"; // Utilise le nom de l'arme
    }
}
