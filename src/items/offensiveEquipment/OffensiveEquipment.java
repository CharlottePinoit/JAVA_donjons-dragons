package items.offensiveEquipment;
import characters.Character;
/**
 * Represents an offensive equipment item.
 * <p>
 * Offensive equipment provides an attack bonus to a character.
 * Subclasses must define whether the equipment is compatible with a given character type.
 * </p>
 */
public abstract class OffensiveEquipment {
    protected int attackBonus;

    //constructeur
    public OffensiveEquipment (int attackBonus) {
        this.attackBonus = attackBonus;
    }
    //getters et setters
    public int getAttackBonus() {
        return attackBonus;
    }
    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public abstract boolean isCompatibleWith(Character character);

    @Override
    public String toString() {
        return "Bonus d'attaque : " + attackBonus;
    }
}
