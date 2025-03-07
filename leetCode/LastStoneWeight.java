package leetCode;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Arrays;

/**
 * LC - 1046
 * Last Stone Weight Problem 
 *
 * Given an array of stone weights, repeatedly smash the two heaviest stones:
 * - If they are equal, both are destroyed.
 * - If they are different, the smaller one is destroyed, and the larger one is reduced by their difference.
 * Continue until at most one stone remains.
 * Return the weight of the last remaining stone, or 0 if none are left.
 *
 * @author Stuti Pandey
 * @date   2025-03-07
 */

public class LastStoneWeight {
    /**
     * @param stones
     * @return
     * ✅ Time Complexity: O(N log N) ✅ Space Complexity: O(N)
     * time complexity LC -> 1 - 2 ms
     * Time -> O(NlogN)
     * PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
     * PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
     */
    public static int lastStoneWeightPQ(int[] stones) {
        // Max Heap using PriorityQueue (default is min heap, so use Collections.reverseOrder())
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the max heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Process until one or no stone is left
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // Get the heaviest stone
            int x = maxHeap.poll(); // Get the second heaviest stone

            if (x != y) {
                maxHeap.add(y - x); // Push the difference back
            }
        }

        // If there's one stone left, return it; otherwise, return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    /**
     * Computes the last remaining stone weight after repeatedly smashing
     * the two heaviest stones according to the given rules.
     *
     * Approach:
     * - Sort the array to get the heaviest two stones.
     * - Smash them and update the array.
     * - Repeat the process until one or zero stones remain.
     * 
     * Time Complexity: O(N^2 log N) (since sorting runs in O(N log N) and happens up to N times)
     * Space Complexity: O(1) (modifies input array in place)
     *
     * @param stones an array of stone weights
     * @return the weight of the last remaining stone, or 0 if none remain
     */
    public static int lastStoneWeight(int[] stones) {
        int len = stones.length;

        while (len > 1) {   // Continue until one or no stones left
            Arrays.sort(stones, 0, len);    // Sort the valid part of the array
            
            int y = stones[len - 1];    // Largest stone
            int x = stones[len - 2];    // Second largest stone

            if (x == y) {
                len -= 2;   // Both stones are destroyed, reducing array size by 2
            } else {
                int diff = Math.abs(y - x);
                stones[len - 2] = diff;
                len -= 1;
            }
        }
        // If no stones are left, return 0; otherwise, return the last remaining stone
        return len == 0 ? 0 : stones[0];
    }
    
    public static void main(String[] args) {
        int[] stones1 = {2, 7, 4, 1, 8, 1}; // Expected output: 1

        System.out.println("Using Priority Queue - max Heap");
        // Start measuring time
        long startTime = System.nanoTime();
        System.out.println(lastStoneWeightPQ(stones1));
        // Stop measuring time
        long endTime = System.nanoTime();
        // Calculate execution time in milliseconds
        double executionTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("Max Heap method Execution time: " + executionTime + " ms");

        System.out.println("Using Array Sorting");
        startTime = System.nanoTime();
        System.out.println(lastStoneWeight(stones1));
        // Stop measuring time
        endTime = System.nanoTime();
        executionTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("Array Sorting method Execution time: " + executionTime + " ms");
        

        // int[] stones2 = {10, 4, 2, 10}; // Expected output: 2
        // System.out.println(lastStoneWeightPQ(stones2));
        // System.out.println(lastStoneWeight(stones2));

    }
}
/**
 * 
 * Why System.nanoTime()?
        More accurate than System.currentTimeMillis(), which only has millisecond precision.
        Avoids system clock adjustments that might affect results.
 */