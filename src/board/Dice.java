package board;

import java.util.Random;

/**
 * Represents a virtual dice.
 * <p>
 * The dice has a fixed number of sides (6) and can be rolled
 * to generate a random number between 1 and 6.
 * </p>
 */
public class Dice {

    /** Number of sides of the dice. */
    private final int sides = 6;

    /** Random number generator used to simulate the dice roll. */
    private final Random random;

    /**
     * Creates a virtual dice with a random number generator.
     * The maximum face value is defined by the {@link #sides} attribute.
     */
    public Dice() {
        random = new Random();
    }

    /**
     * Rolls the dice and returns a random result between
     * 1 and the number of sides (inclusive).
     *
     * @return the result of the dice roll (between 1 and 6)
     */
    public int roll() {
        return random.nextInt(sides) + 1;
    }
}