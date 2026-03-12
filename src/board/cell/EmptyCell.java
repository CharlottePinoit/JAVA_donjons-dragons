package board.cell;

import characters.Character;
/**
 * Represents an empty cell on the game board.
 * <p>
 * When a character lands on this cell, nothing happens.
 * It simply indicates that the position contains no enemies
 * and no items.
 * </p>
 */
public class EmptyCell extends Cell {
    /**
     * Defines the interaction when a character lands on this cell.
     * Since the cell is empty, no action is performed.
     *
     * @param character the character landing on the cell
     */
    @Override
    public void interact(Character character) {
        System.out.println("Cette case est vide. Rien ne se passe.");

    }
    /**
     * Returns a text representation of the empty cell.
     *
     * @return a string describing the cell
     */
    @Override
    public String toString() {
        return "Case vide";
    }
}
