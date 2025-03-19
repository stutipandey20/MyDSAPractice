package queues;
import java.util.PriorityQueue;

/**
 * A Priority Queue is a special type of queue where elements are processed based on priority rather than the order of insertion. 
 * Java provides an in-built PriorityQueue class in java.util that implements a Min-Heap by default.
 * 
 * Author: Stuti Pandey
 * Date: March 19, 2025
 */
public class PriorityQueueExample {
    public static void main(String[] args) {
        // Creating a Min-Heap (default behavior)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Adding elements to the Priority Queue
        pq.add(30);
        pq.add(10);
        pq.add(50);
        pq.add(20);

        // Printing elements (does not guarantee sorted order)
        System.out.println("Priority Queue: " + pq);

        // Removing elements in priority order (smallest first)
        while (!pq.isEmpty()) {
            System.out.println("Polled Element: " + pq.poll());
        }

        // Printing elements (does not guarantee sorted order)
        System.out.println("Priority Queue: " + pq);
    }
}
