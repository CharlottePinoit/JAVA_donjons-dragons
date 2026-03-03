package items.offensiveEquipment.weapon;

public class Mace extends Weapon {

    public Mace() {
        super(3);
    }

    @Override
    public String toString() {
        return "Mace {Bonus d'attaque=" + attackBonus + "}";
    }
}