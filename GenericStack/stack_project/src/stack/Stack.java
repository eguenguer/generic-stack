package stack;

/**
 * A generic, array-based stack (LIFO – Last In, First Out).
 *
 * <p>Because Java does not allow the direct creation of generic arrays,
 * an {@code Object[]} is used internally and elements are cast to {@code T}
 * when retrieved.</p>
 *
 * @param <T> the type of elements held in this stack
 */
public class Stack<T> {

    // ------------------------------------------------------------------ fields

    /** Internal storage array (Object[] instead of T[] due to generic array restriction). */
    private Object[] elements;

    /** Maximum number of elements the stack can hold. */
    private int capacity;

    /** Index of the next free slot; also represents the current number of elements. */
    private int top;

    // --------------------------------------------------------------- constants

    /** Default capacity used when no size is specified. */
    private static final int DEFAULT_CAPACITY = 10;

    // ------------------------------------------------------------- constructors

    /**
     * Creates a stack with the default capacity of {@value #DEFAULT_CAPACITY}.
     */
    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates a stack with the given capacity.
     *
     * @param capacity the maximum number of elements this stack can hold
     * @throws IllegalArgumentException if {@code capacity} is less than 1
     */
    public Stack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be at least 1.");
        }
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.top = 0;
    }

    // ----------------------------------------------------------------- methods

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param element the element to be pushed
     * @throws StackFullException if the stack is already full
     */
    public void push(T element) throws StackFullException {
        if (top == capacity) {
            throw new StackFullException("Stack is full (capacity: " + capacity + ").");
        }
        elements[top] = element;
        top++;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element that was on top of the stack
     * @throws StackEmptyException if the stack is empty
     */
    @SuppressWarnings("unchecked")
    public T pop() throws StackEmptyException {
        if (top == 0) {
            throw new StackEmptyException();
        }
        top--;
        T element = (T) elements[top];
        elements[top] = null; // allow garbage collection
        return element;
    }

    /**
     * Returns (without removing) the element at the top of the stack.
     *
     * @return the element currently on top of the stack
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
     * Returns all stack elements as a semicolon-separated string,
     * starting from the bottom element up to the top.
     *
     * <p>Example for a stack containing 1, 2, 3 (3 on top):
     * {@code "1;2;3"}</p>
     *
     * @return a {@code String} of all elements separated by {@code ;}
     *         or an empty string if the stack is empty
     */
    public String list() {
        if (top == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < top; i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(elements[i]);
        }
        return sb.toString();
    }

    /**
     * Returns {@code true} if the stack contains no elements.
     *
     * @return {@code true} if empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Returns {@code true} if the stack has reached its capacity.
     *
     * @return {@code true} if full, {@code false} otherwise
     */
    public boolean isFull() {
        return top == capacity;
    }

    /**
     * Returns the number of elements currently stored in the stack.
     *
     * @return current element count
     */
    public int size() {
        return top;
    }

    /**
     * Returns the maximum number of elements this stack can hold.
     *
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }
}
