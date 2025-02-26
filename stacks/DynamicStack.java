package stacks;

import java.util.LinkedList;

/**
 * A dynamic stack implementation using LinkedList.
 */

public class DynamicStack<T> {
    private LinkedList<T> stack;

    // Constructor
    public DynamicStack() {
        stack = new LinkedList<>();
    }

    /**
     * Pushes an element onto the stack.
     * @param value The value to push.
     */
    public void push(T value) {
        stack.addFirst(value);
        System.out.println("Pushed: " + value);
    }
    

}
