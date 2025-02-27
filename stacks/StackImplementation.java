package stacks;

/**
     * Main class to test the Stack implementation.
     * Actual implementation is in the Stack.java class
     * Java treats StackImplementation as an inner class, requiring an instance of Stack to run. 
     * Moving it to a separate file resolves this.
     * If want to run in the same class: make StackImplementation static
     * -> doing this ensures it can run without an enclosing Stack instance.
     * 
 */
public class StackImplementation {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();  // Display stack contents

        // Peek at the top element
        System.out.println("Top element: " + stack.peek());

        // Pop elements
        stack.pop();
        stack.display();

        // Check stack status
        System.out.println("Stack size: " + stack.size());
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Pop all elements
        stack.pop();
        stack.pop();
        stack.pop(); // This will trigger "Stack Underflow"
    }
}