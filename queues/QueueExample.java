package queues;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Stuti Pandey
 * Date: March 19, 2025
 */

public class QueueExample {

    public static void main(String[] args) {
        // Creating a queue using a Linked List
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue elements (adding to queue)
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Queue: " + queue);

        // Dequeue (remove elements)
        System.out.println("Removed: " + queue.poll());  // Removes 10
        System.out.println("Queue after poll: " + queue);

        // Peek (get front element without removing)
        System.out.println("Front Element: " + queue.peek());
    }
    
}
