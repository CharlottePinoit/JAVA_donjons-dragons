package characters;

/**
 * Represents a Wizard character.
 * <p>
 * The Wizard is a playable character with predefined
 * life and attack values.
 * </p>
 */
public class Wizard extends Character {

    /**
     * Creates a new Wizard with default attributes.
     *
     * @param name the name of the wizard
     */
    public Wizard(String name) {
        super(name, 6, 8);
    }

    /**
     * Returns a string representation of the wizard.
     *
     * @return a string containing the name, type, life, and attack values
     */
    @Override
    public String toString() {
        return "Personnage : " + getName() + ", Type : Wizard, Vie : " + getLife() + ", Attaque : " + getAttack();
    }
}