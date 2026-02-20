package stack;

/**
 * This error is thrown when you try to add an element to a full stack.
 */
public class StackFullException extends Exception {

    /**
     * Creates the error with a default message.
     */
    public StackFullException() {
        super("Stack is full.");
    }

    /**
     * Creates the error with a custom message.
     *
     * @param message the error message
     */
    public StackFullException(String message) {
        super(message);
    }
}
