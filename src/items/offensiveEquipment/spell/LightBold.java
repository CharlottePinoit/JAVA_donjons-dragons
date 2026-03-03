package items.offensiveEquipment.spell;

import items.offensiveEquipment.spell.Spell;

public class LightBold extends Spell {
    public LightBold() {
        super(2);
    }
    @Override
    public String toString() {
        return "LightBold {Bonus d'attaque=" + attackBonus + "}";
    }
}