package board;
import exceptions.OutOfBoardException;
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

    /**
     * Returns the total number of squares on the board.
     *
     * @return the number of squares (64)
     */
    public int getSize() {
        return size;
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