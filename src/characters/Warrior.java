package characters;

public class Warrior extends Character{
    public Warrior (String name) {
        super(name, 10, 5);
    }

    @Override
    public String toString() {
        return "Personnage : " + getName() + ", Type : Warrior, Vie : " + getLife() + ", Attaque : " + getAttack();
    }
}
