package stack;

/**
 * Exception thrown when pop or peek is called on an empty stack.
 */
public class StackEmptyException extends Exception {

    /**
     * Constructs a StackEmptyException with a default message.
     */
    public StackEmptyException() {
        super("Stack is empty – cannot read any elements.");
    }

    /**
     * Constructs a StackEmptyException with a custom message.
     *
     * @param message the detail message
     */
    public StackEmptyException(String message) {
        super(message);
    }
}
