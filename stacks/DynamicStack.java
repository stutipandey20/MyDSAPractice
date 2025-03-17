package stacks;

import java.util.LinkedList;

/**
 * A dynamic stack implementation using LinkedList.
 * 
 * @param <T> The type of elements stored in the stack.
 * 
 * Author: Stuti Pandey
 * Date: March 17, 2025
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

    /**
     * Pops an element from the stack.
     * @return The popped element.
     * @throws IllegalStateException If the stack is empty.
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        T value = stack.removeFirst();
        System.out.println("Popped: " + value);
        return value;
    }

    /*
     * Peeks at the top element of the stack without removing it.
     * @return The top element
     * @throws IllegalStateException If the stack is empty.
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }
        return stack.getFirst();
    }

    /*
     * Checks is the stack is empty
     * @return True if the stack is empty, otherwise false.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Returns the current size of the stack
     * @return The number of elements in the stack.
     */
    public int size() {
        return stack.size();
    }

    /*
     * Displays the elements of the stack.
     */
    public void display() {
        System.out.println("Stack (top to bottom): " + stack);
    }

    /*
     * Main function to test the Dynamic Stack implementation
     */
    public static void main (String[] args) {
        DynamicStack<Integer> stack = new DynamicStack<>();

        stack.push(10);
        stack.push(30);
        stack.push(20);
        stack.push(50);
        stack.push(40);
        stack.display();

        // check the top element
        System.out.println("Stack top element\t" + stack.peek());

        stack.pop();
        System.out.println("Stack after popping top element");
        stack.display();

        System.out.println("Stack Size: " + stack.size());
        System.out.println("Is Stack Empty? " + stack.isEmpty());
    }
    

}
