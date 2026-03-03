package items.offensiveEquipment.spell;

import items.offensiveEquipment.spell.Spell;

public class Fireball extends Spell {
    public Fireball() {
        super(7);
    }
    @Override
    public String toString() {
        return "Fireball {Bonus d'attaque=" + attackBonus + "}";
    }
}