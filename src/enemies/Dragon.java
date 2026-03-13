package enemies;
/**
 * Represents a Dragon enemy.
 * <p>
 * A Dragon has a high life and attack value compared to other enemies.
 * It is one of the stronger enemies the character can encounter on the board.
 * </p>
 */
public class Dragon extends Enemy {
    /**
     * Creates a new Dragon with predefined attack and life values.
     * Name: "Dragon", Attack: 4, Life: 15
     */
    public Dragon() {
        super("Dragon", 4, 15);
    }

    @Override
    public String getAsciiArt() {
        return  "       \\ _^ /   ,^,\n" +
                "       \\>@@</   ((\n" +
                "         (..)    );)\n" +
                "          vv\\^^^^ /\n" +
                "        /==  ))) )\n" +
                "       ( ==/ )=< \\\n" +
                "      {{{)=(}}}(_}}}\n";
    }
}
