import java.util.Random;

public class Dice {
    private final int sides = 6;
    private final Random random;

    public Dice() {
        random = new Random();
    }
    public int roll() {
        return random.nextInt(sides) +1;
    }
}
