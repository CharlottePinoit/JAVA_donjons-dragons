package characters;

/**
 * Represents a playable character.
 * <p>
 * Each character has a name, life points, an attack value,
 * and a position on the game board.
 * The position is used to track the character's progression
 * during the game.
 * </p>
 */
public abstract class Character {

    /** Current life points of the character */
    private int life;

    /** Attack value of the character */
    private int attack;

    /** Name of the character */
    private String name;

    /** Current position of the character on the board */
    private int position;

    /**
     * Creates a new character with the specified attributes.
     *
     * @param name   the character's name
     * @param life   the base life points
     * @param attack the attack value
     */
    public Character(String name, int life, int attack) {
        this.life = life;
        this.attack = attack;
        this.name = name;
    }

    /**
     * Returns the current life points.
     *
     * @return the life points
     */
    public int getLife() {
        return life;
    }

    /**
     * Updates the life points.
     *
     * @param life the new life value
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * Returns the attack value.
     *
     * @return the attack value
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Updates the attack value.
     *
     * @param attack the new attack value
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Returns the character's name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the character's name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the current position on the board.
     *
     * @return the current position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Updates the position on the board.
     *
     * @param position the new position
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * Checks if the character is still alive.
     *
     * @return {@code true} if life points are greater than 0, otherwise {@code false}
     */
    public boolean isAlive() {
        return life > 0;
    }

    /**
     * Returns a string representation of the character.
     *
     * @return a string containing the name, life, and attack values
     */
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", life=" + life +
                '}';
    }
}