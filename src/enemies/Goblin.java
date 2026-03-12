package enemies;
/**
 * Represents a Goblin enemy.
 * <p>
 * A Goblin is a weak enemy with low attack and life points.
 * It is one of the first enemies the character may encounter
 * on the board.
 * </p>
 */
public class Goblin extends Enemy {
    public Goblin() {
        /**
         * Creates a new Goblin with predefined attack and life values.
         * Name: "Gobelin", Attack: 1, Life: 6
         */
        super("Gobelin", 1, 6);
    }
}
