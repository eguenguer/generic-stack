package stack;

/**
 * A generic stack where the last element in is the first element out (LIFO).
 * Elements are stored in a plain array.
 *
 * @param <T> the type of elements in this stack
 */
public class Stack<T> {

    /** The array that stores all elements. */
    private Object[] elements;

    /** How many elements fit in the stack. */
    private int capacity;

    /** How many elements are currently in the stack. */
    private int top;

    /**
     * Creates a stack with a default capacity of 10.
     */
    public Stack() {
        this.capacity = 10;
        this.elements = new Object[this.capacity];
        this.top = 0;
    }

    /**
     * Creates a stack with the given capacity.
     *
     * @param capacity the maximum number of elements
     */
    public Stack(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[this.capacity];
        this.top = 0;
    }

    /**
     * Puts a new element on top of the stack.
     *
     * @param element the element to add
     * @throws StackFullException if the stack is already full
     */
    public void push(T element) throws StackFullException {
        if (top == capacity) {
            throw new StackFullException();
        }
        elements[top] = element;
        top++;
    }

    /**
     * Removes and returns the top element.
     *
     * @return the top element
     * @throws StackEmptyException if the stack is empty
     */
    @SuppressWarnings("unchecked")
    public T pop() throws StackEmptyException {
        if (top == 0) {
            throw new StackEmptyException();
        }
        top--;
        T element = (T) elements[top];
        elements[top] = null;
        return element;
    }

    /**
     * Returns the top element without removing it.
     *
     * @return the top element
     * @throws StackEmptyException if the stack is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() throws StackEmptyException {
        if (top == 0) {
            throw new StackEmptyException();
        }
        return (T) elements[top - 1];
    }

    /**
     * Returns all elements as a string separated by semicolons.
     * Example: "10;20;30"
     *
     * @return all elements as a string
     */
    public String list() {
        String result = "";
        for (int i = 0; i < top; i++) {
            if (i == 0) {
                result = elements[i].toString();
            } else {
                result = result + ";" + elements[i].toString();
            }
        }
        return result;
    }
}
