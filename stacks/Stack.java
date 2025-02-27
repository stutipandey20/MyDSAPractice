package stacks;

import java.util.logging.Logger;

/**
 * A simple Stack implementation using an array in Java.
 */

class Stack {
    
    private int[] arr;      // Array to store stack elements
    private int top;        // Pointer to the top of the stack
    private int capacity;   // Maximum capacity of the stack

    private static final Logger logger = Logger.getLogger(Stack.class.getName());

    /**
     * Constructor to initialize the stack.
     * @param size The maximum size of the stack.
     */

    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    /**
     * Push an element onto the stack.
     * @param value The value to be added.
     */
    public void push (int value) {
        if (top == capacity - 1) { // Stack overflow check
            logger.info("Stack Overflow! Cannot push " + value);
            return;
        }
        arr[++top] = value;
        System.out.println("Pushed\t" + value);
    }

    /**
     * Pop the top element from the stack.
     * @return The popped element.
     */
    public int pop () {
        if (isEmpty()) { // Stack underflow check
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        }
        System.out.println("Popped: " + arr[top]);
        return arr[top--];
    }

    /**
     * return the top element without removing it
     * @return The top element of the stack.
     */
    public int peek() {
        if (isEmpty()) { // Stack underflow check
            System.out.println("Stack is empty! No top element.");
            return -1;
        }
        return arr[top];
    }

    /**
     * Check if the stack is empty.
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Get the current size of the stack.
     * @return The number of elements in the stack.
     */
    public int size() {
        return top + 1;
    }

    /**
     * Display the stack elements.
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to display.");
            return;
        }
        for(int i = 0; i <= top; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

}

/**
 * 
 * push(int value)	Adds an element to the stack (checks for Stack Overflow)
    pop()	Removes and returns the top element (Stack Underflow check)
    peek()	Returns the top element without removing it
    isEmpty()	Checks if the stack is empty
    size()	Returns the number of elements in the stack
    display()	Prints all elements in the stack

    Uses array-based implementation (fast, O(1) push & pop)
    Exception handling for overflow/underflow
    Simple and efficient for small fixed-size stacks

 */