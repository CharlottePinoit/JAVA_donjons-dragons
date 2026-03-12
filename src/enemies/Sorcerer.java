package enemies;
/**
 * Represents a Sorcerer enemy.
 * <p>
 * A Sorcerer has moderate attack and life points.
 * It can be a challenging opponent for the player,
 * appearing on the board after weaker enemies like Goblins.
 * </p>
 */
public class Sorcerer extends Enemy {
    /**
     * Creates a new Sorcerer with predefined attack and life values.
     * Name: "Sorcier", Attack: 2, Life: 9
     */
    public Sorcerer() {
        super("Sorcier", 2, 9);
    }

    @Override
    public String getAsciiArt() {
        return  "  /\\  \n" +
                " /__\\ \n" +
                " (x x) \n" +
                " /||\\ \n" +
                "  /\\  \n";
    }
}
