package characters;

/**
 * Represents a Warrior character.
 * <p>
 * The Warrior is a playable character with predefined
 * life and attack values.
 * </p>
 */
public class Warrior extends Character {

    /**
     * Creates a new Warrior with default attributes.
     *
     * @param name the name of the warrior
     */
    public Warrior(String name) {
        super(name, 10, 5);
    }

    /**
     * Returns a string representation of the warrior.
     *
     * @return a string containing the name, type, life, and attack values
     */
    @Override
    public String toString() {
        return "Personnage : " + getName() + ", Type : Warrior, Vie : " + getLife() + ", Attaque : " + getAttack();
    }
}