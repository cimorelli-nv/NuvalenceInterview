package cimorell.nv.exception;

/**
 * The specified value is invalid in this context.
 */
public class InvalidValueError extends Error {
    public InvalidValueError(String message) {
        super(message);
    }
}
