package items.offensiveEquipment;
import characters.Character;
/**
 * Represents an offensive equipment item.
 * <p>
 * Offensive equipment increases a character's attack value.
 * Subclasses must define whether the equipment is compatible
 * with a given character type (e.g., Warrior, Wizard).
 * </p>
 */
public abstract class OffensiveEquipment {
    /** Attack bonus provided by this equipment */
    protected int attackBonus;
    /** Name of the equipment */
    protected String name;

    //constructeur
    /**
     * Creates a new offensive equipment with a specified attack bonus and name.
     *
     * @param attackBonus the attack points this equipment adds to a character
     * @param name the name of the equipment
     */
    public OffensiveEquipment (int attackBonus, String name) {

        this.attackBonus = attackBonus;
        this.name = name;
    }

    //getters et setters
    /**
     * Returns the attack bonus of the equipment.
     *
     * @return the attack bonus
     */
    public int getAttackBonus() {
        return attackBonus;
    }
    /**
     * Updates the attack bonus of the equipment.
     *
     * @param attackBonus the new attack bonus
     */
    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if the equipment is compatible with the given character.
     *
     * @param character the character to check compatibility with
     * @return {@code true} if the character can equip this item, otherwise {@code false}
     */
    public abstract boolean isCompatibleWith(characters.Character character);

    public abstract String getAsciiArt();
    /**
     * Returns a string representation of the offensive equipment.
     *
     * @return a string describing the attack bonus
     */
    @Override
    public String toString() {
        return name + " (Bonus d'attaque : " + attackBonus + ")";
    }
}
