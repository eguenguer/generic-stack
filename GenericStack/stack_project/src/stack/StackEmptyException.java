package stack;

/**
 * This error is thrown when you try to read from an empty stack.
 */
public class StackEmptyException extends Exception {

    /**
     * Creates the error with a default message.
     */
    public StackEmptyException() {
        super("Stack is empty.");
    }

    /**
     * Creates the error with a custom message.
     *
     * @param message the error message
     */
    public StackEmptyException(String message) {
        super(message);
    }
}
