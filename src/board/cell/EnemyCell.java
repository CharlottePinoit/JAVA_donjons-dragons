package board.cell;
import characters.Character;
import enemies.Enemy;
/**
 * Represents a cell containing an enemy.
 * <p>
 * When a character lands on this cell, a combat starts between
 * the character and the enemy present on the cell.
 * The character attacks first, then the enemy may retaliate
 * if it is still alive.
 * </p>
 */
public class EnemyCell extends Cell {
    /** The enemy present on this cell */
    private Enemy enemy;
    /**
     * Creates a new cell containing an enemy.
     *
     * @param enemy the enemy placed on this cell
     */
    public EnemyCell(Enemy enemy) {
        this.enemy = enemy;
    }

    /**
     * Handles the interaction between the character and the enemy.
     * The character attacks first. If the enemy survives, it retaliates once.
     *
     * @param character the character landing on the cell
     */
    @Override
    public void interact(Character character) {
        System.out.println("Vous rencontrez un ennemi : " + enemy.toString());

        // Le perso attaque l'ennemi
        enemy.setLife(Math.max(0, enemy.getLife() - character.getAttack()));
        System.out.println(character.getName() + " attaque " + enemy.getName() + " ! Il reste " + enemy.getLife() + " PV à l'ennemi.");

        // Vérifie si l'ennemi est encore en vie
        if (enemy.isAlive()) {
            // L'ennemi riposte une fois
            character.setLife(Math.max(0, character.getLife() - enemy.getAttack()));
            System.out.println(enemy.getName() + " riposte et attaque " + character.getName() + " ! Il reste " + character.getLife() + " PV à " + character.getName() + ".");
            System.out.println(enemy.getName() + " s'enfuit après avoir riposté.");
        } else {
            System.out.println(enemy.getName() + " est vaincu !");
        }
    }
    /**
     * Returns a text representation of the enemy cell.
     *
     * @return a string describing the enemy on the cell
     */
    @Override
    public String toString() {
        return "Case avec un ennemi : " + enemy.getName() + " (PV: " + enemy.getLife() + ", Attaque: " + enemy.getAttack() + ")";
    }
}
