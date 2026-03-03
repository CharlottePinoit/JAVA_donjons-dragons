package characters;

public class Wizard extends Character {
    public Wizard(String name) {
        super(name, 10, 5);
    }
    @Override
    public String toString() {
        return "Personnage : " + getName() + ", Type : Wizard, Vie : " + getLife() + ", Attaque : " + getAttack();
    }
}

