package exceptions;

/**
 * Exception thrown when an invalid mark is provided (e.g., negative score or above maximum).
 */
public class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}
