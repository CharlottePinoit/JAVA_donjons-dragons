package board;
import exceptions.OutOfBoardException;
import board.cell.Cell;
import board.cell.EmptyCell;
import board.cell.EnemyCell;
import board.cell.ItemCell;
import enemies.Dragon;
import enemies.Goblin;
import enemies.Sorcerer;
import exceptions.OutOfBoardException;
import java.util.ArrayList;

/**
 * Represents the game board.
 * <p>
 * The board contains a fixed number of squares and is used
 * to track the character's progression during the game.
 * </p>
 */
public class Board {

    /** Total number of squares on the board */
    private final int size = 64;

    /** List of cells on the board */
    private final ArrayList<Cell> cells;

    /**
     * Creates a new board with 64 cells.
     * The cells are randomly initialized with enemies, items, or empty cells.
     */
    public Board() {
        this.cells = new ArrayList<>(size);

        // Initialisation du plateau avec des cases variées
        for (int i = 0; i < size; i++) {
            double randomValue = Math.random();
            if (randomValue < 0.3) {
                cells.add(new EnemyCell(new Goblin()));
            } else if (randomValue < 0.6) {
                cells.add(new EnemyCell(new Sorcerer()));
            } else if (randomValue < 0.8) {
                cells.add(new EnemyCell(new Dragon()));
            } else if (randomValue < 0.9) {
                cells.add(new ItemCell());
            } else {
                cells.add(new EmptyCell());
            }
        }
    }

    /**
     * Returns the total number of squares on the board.
     *
     * @return the number of squares (64)
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the cell at the specified position.
     *
     * @param position the position on the board (1-based index)
     * @return the cell at the specified position
     */
    public Cell getCell(int position) {
        return cells.get(position - 1); // Convert to 0-based index
    }

    /**
     * Checks if a position is within the board limits.
     *
     * @param position the position to check
     * @throws OutOfBoardException if the position exceeds the board size
     */
    public void checkPosition(int position) throws OutOfBoardException {
        if (position > size) {
            throw new OutOfBoardException(
                    "Position " + position + " exceeds the board size (" + size + ")"
            );
        }
    }
}