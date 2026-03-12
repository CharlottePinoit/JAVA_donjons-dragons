package board.cell;
import characters.Character;

/**
 * Represents a cell on the game board.
 * <p>
 * A cell is a position on the board that the player can land on.
 * Each type of cell defines its own interaction with the character
 * (enemy, treasure, empty cell, etc.).
 * </p>
 */
public abstract class Cell {
    /**
     * Defines what happens when a character lands on this cell.
     *
     * @param character the character that interacts with the cell
     */
    public abstract void interact(Character character);
    /**
     * Returns a text representation of the cell.
     *
     * @return a string describing the cell
     */
    @Override
    public abstract String toString();
}
