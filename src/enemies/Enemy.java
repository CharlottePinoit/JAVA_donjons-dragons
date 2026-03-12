package enemies;

import characters.Character;

/**
 * Represents an enemy in the game.
 * <p>
 * Each enemy has a name, attack value, and life points.
 * Enemies can attack characters and their life points persist
 * until they are defeated.
 * </p>
 */
public abstract class Enemy {
    /** Name of the enemy */
    protected String name;
    /** Attack value of the enemy */
    protected int attack;
    /** Current life points of the enemy */
    protected int life;
    /**
     * Creates a new enemy with the specified attributes.
     *
     * @param name   the enemy's name
     * @param attack the attack value
     * @param life   the initial life points
     */
    public Enemy(String name, int attack, int life) {
        this.name = name;
        this.attack = attack;
        this.life = life;
    }

    /**
     * Attacks a character, reducing their life points by the enemy's attack value.
     *
     * @param character the character being attacked
     */
    public void attack(Character character) {
        character.setLife(character.getLife() - this.attack);
        System.out.println(this.name + " attaque " + character.getName() + " ! Il reste " + character.getLife() + " PV à " + character.getName());
    }

    // Getters et setters
    /** Returns the name of the enemy. */
    public String getName() {
        return name;
    }
    /** Returns the attack value of the enemy. */
    public int getAttack() {
        return attack;
    }
    /** Returns the current life points of the enemy. */
    public int getLife() {
        return life;
    }
    /** Updates the life points of the enemy. */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * Checks if the enemy is still alive.
     *
     * @return {@code true} if life points are greater than 0, otherwise {@code false}
     */
    public boolean isAlive() {
        return life > 0;
    }
    /**
     * Returns a string representation of the enemy.
     *
     * @return a string containing the name, life, and attack values
     */
    @Override
    public String toString() {
        return name + " (PV: " + life + ", Attaque: " + attack + ")";
    }
}

