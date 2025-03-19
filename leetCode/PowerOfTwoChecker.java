package leetCode;
import java.util.Scanner;

/*
 * LeetCode : 231 Power of Two
 * 
 * Author: Your Name
 * Date: March 19, 2025
 * Description: This program checks whether a number is a power of 2 using three different approaches:
 *  1. Bitwise operation -> Most efficient, best choice
 *  2. Iterative (loop-based) approach -> Simple but slightly slower
 *  3. Recursive approach -> Extra space due to recursion stack
 */

public class PowerOfTwoChecker {
     /*
        * Approach 1: Bitwise Operation
        * Uses (n & (n-1)) == 0 to determine if n is a power of 2.
        *
        * Time Complexity: O(1) - Constant time since it's a single operation.
        * Space Complexity: O(1) - No extra space used.    
    */
    public static boolean isPowerOfTwoBitwise(int n) {
        if (n <= 0) {
            return false;   // Negative numbers & zero are not powers of 2
        } 
        return (n & (n - 1)) == 0;
    }

    /**
     * Approach 2: Using loop - Iterative approach
     * Continuously divides n by 2 while it is divisible.
     * 
     * Time Complexity: O(log n) - Because we divide n by 2 in each step.
     * Space Complexity: O(1) - No extra space used.
     */
    public static boolean isPowerOfTwoLoop(int n) {
        if (n <= 0) {
            return false;   // Negative numbers & zero are not powers of 2
        }
        while (n % 2 == 0) {
            n /= 2;     // Keep dividing n by 2
        }
        return n == 1;  // If we end up with 1, it's a power of 2
    }

    /**
     * Approach 3: Using Recursion
     * Recursively divides n by 2 until it reaches 1.
     * 
     * Time Complexity: O(log n) - Since we divide n by 2 in each recursive call.
     * Space Complexity: O(log n) - Because of recursive function call stack.
     */
    public static boolean isPowerOfTwoRecursion(int n) {
        if (n <= 0) return false;   // Negative numbers & zero are not powers of 2
        if (n == 1) return true;    // Base case: 2^0 = 1 is a power of 2
        if (n % 2 != 0) return false;   // If n is not divisible by 2, it's not a power of 2

        return isPowerOfTwoRecursion(n / 2);  // Recursive call with n / 2
    }

    /**
     * Main function to test all three methods.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        // Measure execution time for Bitwise approach
        long startTime = System.nanoTime();
        boolean resultBitwise = isPowerOfTwoBitwise(n);
        long endTime = System.nanoTime();
        long timeBitwise = endTime - startTime;

        // Measure execution time for Loop approach
        startTime = System.nanoTime();
        boolean resultLoop = isPowerOfTwoLoop(n);
        endTime = System.nanoTime();
        long timeLoop = endTime - startTime;

       // Measure execution time for Recursive approach
       startTime = System.nanoTime();
       boolean resultRecursion = isPowerOfTwoRecursion(n);
       endTime = System.nanoTime();
       long timeRecursion = endTime - startTime;

       // Print results
       System.out.println("\nResults:");
       System.out.println("Bitwise Approach: " + resultBitwise + " | Time taken: " + timeBitwise + " ns");
       System.out.println("Loop Approach: " + resultLoop + " | Time taken: " + timeLoop + " ns");
       System.out.println("Recursive Approach: " + resultRecursion + " | Time taken: " + timeRecursion + " ns");

       scanner.close();
    }
}
