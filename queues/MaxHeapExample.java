package queues;
import java.util.Collections;
import java.util.PriorityQueue;


/**
 * Author: Stuti Pandey
 * Date: March 19, 2025
 */

public class MaxHeapExample {
    public static void main(String[] args) {

        // Creating a Max-Heap using Collections.reverseOrder()
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(30);
        maxHeap.add(10);
        maxHeap.add(50);
        maxHeap.add(20);

        System.out.println("Max-Heap: " + maxHeap);

        // Removing elements (largest first)
        while (!maxHeap.isEmpty()) {
            System.out.println("Polled Element: " + maxHeap.poll());
        }

        System.out.println("Max-Heap: " + maxHeap);
    }
}
