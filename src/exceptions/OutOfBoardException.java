package exceptions;

/**
 * Exception thrown when a character's position
 * exceeds the limits of the game board.
 */
public class OutOfBoardException extends Exception {

    /**
     * Constructs a new OutOfBoardException with the specified detail message.
     *
     * @param message the detail message
     */
    public OutOfBoardException(String message) {
        super(message);
    }
}
