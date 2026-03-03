package items.offensiveEquipment.spell;
import characters.Character;
import characters.Wizard;
import items.offensiveEquipment.OffensiveEquipment;

public class Spell extends OffensiveEquipment {
    public Spell(int attackBonus) {
        super(attackBonus);
    }

    @Override
    public boolean isCompatibleWith(Character character) {
        return character instanceof Wizard;
    }
    @Override
    public String toString() {
        return "Spell {Bonus d'attaque=" + attackBonus + "}";
    }
}