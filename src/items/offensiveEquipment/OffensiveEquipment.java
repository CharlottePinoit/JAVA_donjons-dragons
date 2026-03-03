package items.offensiveEquipment;
import characters.Character;

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
