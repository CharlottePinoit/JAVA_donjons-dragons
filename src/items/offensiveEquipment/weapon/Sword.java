package items.offensiveEquipment.weapon;

public class Sword extends Weapon {
    public Sword() {
        super(5);
    }
    @Override
    public String toString() {
        return "Sword {Bonus d'attaque=" + attackBonus + "}";
    }
}
