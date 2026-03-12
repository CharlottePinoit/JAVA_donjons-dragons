package items.offensiveEquipment.weapon;

import characters.Warrior;

/**
 * Represents a Sword weapon.
 * <p>
 * The Sword is a specific type of {@link Weapon} with a fixed attack bonus of 5.
 * It can only be equipped by {@link characters.Warrior} characters.
 * </p>
 */
public class Sword extends Weapon {

    /**
     * Creates a new Sword with a default attack bonus of 5.
     */
    public Sword() {
        super(5, "épée");
    }
    @Override
    public boolean isCompatibleWith(characters.Character character) {
        return character instanceof Warrior;
    }

    @Override
    public String getAsciiArt(){
        return  "   /\\   \n" +
                "   ||   \n" +
                "   ||   \n" +
                "--=||=--\n" +
                "   ||   \n" +
                "   \\/   \n";
    }
    /**
     * Returns a string representation of the Sword.
     *
     * @return a string containing the attack bonus
     */
    @Override
    public String toString() {
        return super.toString(); // Utilise la méthode toString() de Weapon
    }
}