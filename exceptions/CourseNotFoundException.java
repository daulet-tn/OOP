package exceptions;

/**
 * Exception thrown when a course cannot be found in the database.
 */
public class CourseNotFoundException extends Exception {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
