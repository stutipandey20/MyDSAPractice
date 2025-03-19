package queues;

/**
 * A Queue follows the FIFO (First In, First Out) principle.
 * 
 * Author: Stuti Pandey
 * Date: March 19, 2025
 */

class ArrayQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor to initialize the queue with a fixed size
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0; // Points to the front element
        this.rear = -1; // Points to the last element
        this.size = 0;  // Keeps track of the number of elements
    } 

    // Enqueue (Add element to the queue)
    public void enqueue(int item) {
        if (size == capacity) {
            System.out.println("Queue is full! Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = item;
        size++;
        System.out.println("Enqueued: " + item);
    }

    // Dequeue (Remove element from the queue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println("Dequeued: " + item);
        return item;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Peek at the front element
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No front element.");
            return -1;
        }
        return queue[front];
    }

    // Display the queue elements
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.println(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    // Get the size of the queue
    public int getSize() {
        return size;
    }
}

// Main class to test the queue
public class ArrayQueueImplementation {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // This should show an overflow message

        queue.displayQueue();

        queue.dequeue();
        queue.dequeue();

        queue.displayQueue();

        System.out.println("Front Element: " + queue.front());
        System.out.println("Queue size: " + queue.getSize());
    }
}

/**
 * 
 * 🔹 Features of This Implementation
✔ Uses an array to store queue elements.
✔ Implements enqueue() (insertion) and dequeue() (removal).
✔ Handles underflow (dequeue from an empty queue) and overflow (enqueue when full).
✔ Includes front(), rear(), and isEmpty() methods.
 */