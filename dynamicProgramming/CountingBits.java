package dynamicProgramming;

import java.util.Arrays;

/**
 * Leetcode 338: Counting Bits
 * Author: Stuti Pandey
 * Date: March 11, 2025
 * 
 * Problem Statement:
 * Given an integer n, return an array ans of length n + 1 such that:
 * ans[i] = number of 1's in the binary representation of i.
 * 
 * Constraints:
 * - 0 <= n <= 10^5
 * 
 * Follow-up: Can you solve this in O(n) time complexity?
 */

public class CountingBits {
    
    public CountingBits() {}

    /**
     * ✅ Brute Force Approach (O(n log n) time, O(n) space)
     * - Convert each number to binary and count 1s.
     */
    public static int[] countBitsBruteForce(int n) {
        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int count = 0;
            int num = i;

            // Count set bits in the binary representation
            while (num > 0) {
                count += num & 1; // Check last bit
                num >>= 1; // Shift right
            }
            result[i] = count;

        }
        return result;
    } 

    /**
     * ✅ Optimized Approach: DP + Bit Manipulation (O(n) time, O(n) space)
     * Uses formula: ans[i] = ans[i >> 1] + (i & 1)
     * - ans[i >> 1]: Number of 1s in i/2
     * - (i & 1): Adds 1 if the last bit is 1
     */
    public static int[] countBitsOptimized(int n) {
        int[] result = new int[n + 1];
        result[0] = 0; // Base case

        for (int i = 1; i < n; i++) {
            result[i] = result[i >> 1] + (i & 1); 
        }

        return result;
    }

    /**
     * ✅ Main function to test both solutions
     */
    public static void main (String[] args) {
        int[] testCases = {2, 5, 10, 1000}; // Added a larger test case for performanc check

        System.out.println("Testing Brute Force Approach:");
        for (int n : testCases) {
            long startTime = System.nanoTime(); // Start time
            int[] result = countBitsBruteForce(n);
            long endTime = System.nanoTime(); // End time

            System.out.println("n = " + n + " -> " + Arrays.toString(result));
            System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
        }

        System.out.println("\nTesting Optimized Approach:");
        for (int n : testCases) {
            long startTime = System.nanoTime(); // Start time
            int[] result = countBitsOptimized(n);
            long endTime = System.nanoTime(); // End time

            System.out.println("n = " + n + " -> " + Arrays.toString(result));
            System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
        }
    }
}
