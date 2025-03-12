package leetCode;

/**
 * LeetCode - 190. Reverse Bits
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * Time Complexity: O(1) (32 loops)
 * Space Complexity: O(1)
 * Notes: Simple but not the fastest
 * 
 * @author Stuti Pandey
 * @date   2025-03-12
 */

// Simple iterative approach to reverse bits of a 32-bit integer
public class ReverseBitsSimple {
    
    // Function to reverse bits using bitwise operations
    public static int reverseBits(int n) {
        int result = 0;
        // Process all 32 bits
        for (int i = 0; i < 32; i++) {
            result <<= 1;       // Shift result left to make space for the next bit
            result |= (n & 1);  // Extract the last bit of 'n' and add it to 'result'
            n >>= 1;            // Shift 'n' right to process the next bit
        }
        return result;
    }

    public static void main(String[] args) {
        int input = 0b00000010100101000001111010011100; // Example input

        long startTime = System.nanoTime(); // Start time
        int output = reverseBits(input);
        long endTime = System.nanoTime(); // End time
        
        System.out.println("Reversed Bits (Decimal): " + output);
        System.out.println("Reversed Bits (Binary) : " + Integer.toBinaryString(output));
        System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}
/**
 * 
 * 🔹 How It Works?
        We initialize result = 0.
        We extract each bit of n from right to left and place it in result from left to right.
        We left shift result and right shift n in each iteration.
        After 32 iterations, result holds the reversed bits.
 */

