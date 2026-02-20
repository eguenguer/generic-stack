package test;

import stack.Stack;
import stack.StackEmptyException;
import stack.StackFullException;

/**
 * Test class for the generic {@link stack.Stack} implementation.
 *
 * Tests are grouped into two sections:
 * <ol>
 *   <li>Integer stack – tests numeric LIFO behaviour and boundary conditions</li>
 *   <li>String stack  – tests text elements and the list() method</li>
 * </ol>
 */
public class StackTest {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  STACK TEST SUITE");
        System.out.println("========================================\n");

        testIntegerStack();
        testStringStack();
    }

    // ---------------------------------------------------------------- Integer stack tests

    /**
     * Runs all tests for a stack holding {@link Integer} values.
     */
    private static void testIntegerStack() {

        System.out.println("--- Integer Stack Tests ---\n");

        // Create an integer stack with capacity 3
        Stack<Integer> intStack = new Stack<>(3);

        // --- Test 1: isEmpty on a brand-new stack
        System.out.println("Test 1 – isEmpty on empty stack:");
        System.out.println("  Expected: true  | Got: " + intStack.isEmpty());

        // --- Test 2: peek on empty stack must throw StackEmptyException
        System.out.println("\nTest 2 – peek on empty stack (expect StackEmptyException):");
        try {
            intStack.peek();
            System.out.println("  ERROR: No exception thrown!");
        } catch (StackEmptyException e) {
            System.out.println("  OK – StackEmptyException caught: " + e.getMessage());
        }

        // --- Test 3: pop on empty stack must throw StackEmptyException
        System.out.println("\nTest 3 – pop on empty stack (expect StackEmptyException):");
        try {
            intStack.pop();
            System.out.println("  ERROR: No exception thrown!");
        } catch (StackEmptyException e) {
            System.out.println("  OK – StackEmptyException caught: " + e.getMessage());
        }

        // --- Test 4: push elements and verify size
        System.out.println("\nTest 4 – push 3 integers (10, 20, 30):");
        try {
            intStack.push(10);
            intStack.push(20);
            intStack.push(30);
            System.out.println("  Stack size after 3 pushes – Expected: 3 | Got: " + intStack.size());
            System.out.println("  isFull – Expected: true | Got: " + intStack.isFull());
        } catch (StackFullException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }

        // --- Test 5: push onto full stack must throw StackFullException
        System.out.println("\nTest 5 – push onto full stack (expect StackFullException):");
        try {
            intStack.push(99);
            System.out.println("  ERROR: No exception thrown!");
        } catch (StackFullException e) {
            System.out.println("  OK – StackFullException caught: " + e.getMessage());
        }

        // --- Test 6: peek returns top element without removing it
        System.out.println("\nTest 6 – peek at top element:");
        try {
            int peeked = intStack.peek();
            System.out.println("  Expected: 30 | Got: " + peeked);
            System.out.println("  Size unchanged – Expected: 3 | Got: " + intStack.size());
        } catch (StackEmptyException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }

        // --- Test 7: list() returns semicolon-separated elements bottom-to-top
        System.out.println("\nTest 7 – list() output:");
        System.out.println("  Expected: 10;20;30 | Got: " + intStack.list());

        // --- Test 8: pop returns elements in LIFO order
        System.out.println("\nTest 8 – pop all elements (LIFO order 30 → 20 → 10):");
        try {
            System.out.println("  Pop 1 – Expected: 30 | Got: " + intStack.pop());
            System.out.println("  Pop 2 – Expected: 20 | Got: " + intStack.pop());
            System.out.println("  Pop 3 – Expected: 10 | Got: " + intStack.pop());
            System.out.println("  isEmpty after all pops – Expected: true | Got: " + intStack.isEmpty());
        } catch (StackEmptyException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }

        // --- Test 9: list() on empty stack returns empty string
        System.out.println("\nTest 9 – list() on empty stack:");
        System.out.println("  Expected: \"\" | Got: \"" + intStack.list() + "\"");

        System.out.println();
    }

    // ---------------------------------------------------------------- String stack tests

    /**
     * Runs all tests for a stack holding {@link String} values.
     */
    private static void testStringStack() {

        System.out.println("--- String Stack Tests ---\n");

        // Create a string stack using the default constructor (capacity 10)
        Stack<String> strStack = new Stack<>();

        // --- Test 10: push several words and verify list output
        System.out.println("Test 10 – push words: alpha, beta, gamma, delta:");
        try {
            strStack.push("alpha");
            strStack.push("beta");
            strStack.push("gamma");
            strStack.push("delta");
            System.out.println("  list() – Expected: alpha;beta;gamma;delta | Got: " + strStack.list());
        } catch (StackFullException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }

        // --- Test 11: peek returns "delta" (last pushed)
        System.out.println("\nTest 11 – peek at top element:");
        try {
            String top = strStack.peek();
            System.out.println("  Expected: delta | Got: " + top);
            System.out.println("  Size unchanged – Expected: 4 | Got: " + strStack.size());
        } catch (StackEmptyException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }

        // --- Test 12: pop two elements, check list afterwards
        System.out.println("\nTest 12 – pop 2 elements, then list():");
        try {
            String first  = strStack.pop(); // should be "delta"
            String second = strStack.pop(); // should be "gamma"
            System.out.println("  Pop 1 – Expected: delta | Got: " + first);
            System.out.println("  Pop 2 – Expected: gamma | Got: " + second);
            System.out.println("  list() – Expected: alpha;beta | Got: " + strStack.list());
        } catch (StackEmptyException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }

        // --- Test 13: push after pop – stack works correctly as a reusable structure
        System.out.println("\nTest 13 – push 'epsilon' after partial pop:");
        try {
            strStack.push("epsilon");
            System.out.println("  list() – Expected: alpha;beta;epsilon | Got: " + strStack.list());
            System.out.println("  peek()  – Expected: epsilon | Got: " + strStack.peek());
        } catch (StackFullException | StackEmptyException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }

        // --- Test 14: default capacity check
        System.out.println("\nTest 14 – default capacity:");
        System.out.println("  Expected: 10 | Got: " + strStack.getCapacity());

        // --- Test 15: fill stack to capacity, then verify isFull
        System.out.println("\nTest 15 – fill remaining slots to capacity:");
        try {
            // currently 3 elements in stack with capacity 10 → push 7 more
            for (int i = 1; i <= 7; i++) {
                strStack.push("word" + i);
            }
            System.out.println("  isFull – Expected: true | Got: " + strStack.isFull());
            System.out.println("  size   – Expected: 10  | Got: " + strStack.size());
        } catch (StackFullException e) {
            System.out.println("  ERROR: " + e.getMessage());
        }

        // --- Test 16: attempt to push onto the now-full string stack
        System.out.println("\nTest 16 – push onto full string stack (expect StackFullException):");
        try {
            strStack.push("overflow");
            System.out.println("  ERROR: No exception thrown!");
        } catch (StackFullException e) {
            System.out.println("  OK – StackFullException caught: " + e.getMessage());
        }

        System.out.println("\n========================================");
        System.out.println("  ALL TESTS COMPLETED");
        System.out.println("========================================");
    }
}
