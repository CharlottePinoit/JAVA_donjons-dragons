package characters;

import items.consumable.Consumable;
import items.offensiveEquipment.OffensiveEquipment;

/**
 * Represents a playable character in the game.
 * <p>
 * Each character has a name, life points, an attack value,
 * and a position on the game board. The character can equip
 * offensive equipment and use consumable items during the game.
 * </p>
 */
public abstract class Character {

    private int id;
    /** Current life points of the character */
    private int life;

    /** Attack value of the character */
    private int attack;

    /** Name of the character */
    private String name;

    /** Current position of the character on the board */
    private int position;

    /** Maximum life points of the character */
    private int maxLife;

    /** Currently equipped offensive equipment */
    private OffensiveEquipment offensiveEquipment;

    /**
     * Creates a new character with the specified attributes.
     * * The {@code maxLife} attribute is automatically set to the initial life value.
     *
     * @param name   the character's name
     * @param life   the base life points
     * @param attack the attack value
     */
    public Character(String name, int life, int attack) {
        this.life = life;
        this.attack = attack;
        this.name = name;
        this.maxLife = life;
        this.id = 0;
    }
    //getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
     * Returns the maximum life points of the character.
     *
     * @return the maximum life points
     */
    public int getMaxLife() {
        return maxLife;
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

    /**
     * Equips an offensive equipment if it is compatible
     * and better than the currently equipped one.
     *
     * @param equipment the equipment to equip
     */
    public void equipOffensiveEquipment(OffensiveEquipment equipment) {
        if (equipment.isCompatibleWith(this)) {
            // Si l'équipement actuel est null ou moins bon que le nouveau
            if (this.offensiveEquipment == null || equipment.getAttackBonus() > this.offensiveEquipment.getAttackBonus()) {
                this.offensiveEquipment = equipment;
                this.attack += equipment.getAttackBonus(); // Augmente l'attaque du personnage
                System.out.println(this.name + " a équipé " + equipment + ". Nouvelle attaque : " + this.attack);
            } else {
                System.out.println("L'équipement actuel est déjà meilleur.");
            }
        } else {
            System.out.println("Cet équipement n'est pas compatible avec " + this.name);
        }
    }
    /**
     * Returns the currently equipped offensive equipment.
     *
     * @return the offensive equipment
     */
    public OffensiveEquipment getOffensiveEquipment() {
        return offensiveEquipment;
    }

    /**
     * Uses a consumable item to restore life points.
     * The life points cannot exceed the maximum life value.
     *
     * @param consumable the consumable item to use
     */
    public void useConsumable(Consumable consumable) {
        this.life += consumable.getHealing();
        if (this.life > this.maxLife) {
            this.life = this.maxLife; // Ne dépasse pas les PV max
        }
        System.out.println(this.name + " a utilisé " + consumable + ". Points de vie : " + this.life);
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