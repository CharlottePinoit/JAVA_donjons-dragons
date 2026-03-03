package items.offensiveEquipment.weapon;
import characters.Character;
import characters.Warrior;
import items.offensiveEquipment.OffensiveEquipment;

public class Weapon extends OffensiveEquipment {
    public Weapon(int attackBonus) {
        super(attackBonus);
    }

    @Override
    public boolean isCompatibleWith(Character character) {
       return character instanceof Warrior;
    }
    @Override
    public String toString() {
        return "Weapon {Bonus d'attaque=" + attackBonus + "}";
    }
}
