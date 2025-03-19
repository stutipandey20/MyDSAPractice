package queues;
import java.util.PriorityQueue;


/**
 * Custom Priority Queue Implementation
 * 
 * Author: Stuti Pandey
 * Date: March 19, 2025
 */

class Task {
    String name;
    int priority;

    // Constructor
    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    // Override toString for meaningful output
    public String toString() {
        return "Task{name='" + name + "', priority =" + priority + "}";
    }
}

public class CustomPriorityQueueExample {
    public static void main(String[] args) {
        // Min-Heap (Lowest priority first)
        PriorityQueue<Task> taskQueue = new PriorityQueue<>((a, b) -> a.priority - b.priority);

        taskQueue.add(new Task("Write Report", 3));
        taskQueue.add(new Task("Fix Bug", 1));
        taskQueue.add(new Task("Attend Meeting", 2));

        // Process tasks by Priority
        while (!taskQueue.isEmpty()) {
            System.out.println("Processing: " + taskQueue.poll());
        }

    }
}

/**
 * a.priority - b.priority → Ascending Order (Min-Heap)
    b.priority - a.priority → Descending Order (Max-Heap)
    Lambda Expressions provide a clean way to define custom comparators inline.
 * 
 * If you want a Max-Heap (higher priority number = higher priority), modify the comparator:
 * 
 * PriorityQueue<Task> taskQueue = new PriorityQueue<>((a, b) -> b.priority - a.priority);
 * 
 * Processing: Task{name='Write Report', priority=3}
    Processing: Task{name='Attend Meeting', priority=2}
    Processing: Task{name='Fix Bug', priority=1}
 */