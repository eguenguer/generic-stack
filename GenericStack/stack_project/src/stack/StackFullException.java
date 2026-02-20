package stack;

/**
 * Exception thrown when an element is pushed onto a full stack.
 */
public class StackFullException extends Exception {

    /**
     * Constructs a StackFullException with a default message.
     */
    public StackFullException() {
        super("Stack is full – cannot push any more elements.");
    }

    /**
     * Constructs a StackFullException with a custom message.
     *
     * @param message the detail message
     */
    public StackFullException(String message) {
        super(message);
    }
}
