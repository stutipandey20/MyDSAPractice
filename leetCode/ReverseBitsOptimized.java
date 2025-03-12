package leetCode;

/**
 * LeetCode - 190. Reverse Bits
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * Use the Lookup Table approach when the function is called repeatedly, as it significantly improves performance
 * 
 * Time Complexity: O(1) (4 lookups)
 * Space Complexity: O(1) after setup
 * Notes: Fast for multiple calls
 * 
 * @author Stuti Pandey
 * @date   2025-03-12
 */

// Optimized approach using a lookup table for 8-bit reversals
public class ReverseBitsOptimized {
    
    // Lookup table for reversing 8-bits value
    private static final int[] lookupTable = new int[256];
    
    // static block to initiate the lookup table
    static {
        for(int i = 0; i < 256; i++) {
            lookupTable[i] = reverseByte(i);
        }
    }

    // Function to reverse 8-bit values
    private static int reverseByte(int b) {
        int result = 0;
        for(int i = 0; i < 8; i++) {
            result <<= 1;
            result |= (b & 1);
            b >>= 1;
        }
        return result;
    }

    // function to 
    public static int reverseBits(int n) {
        return (lookupTable[n & 0xFF] << 24) |  // Reverse last 8 bits
        (lookupTable[(n >>> 8) & 0xFF] << 16) | // Reverse 2nd last 8 bits
        (lookupTable[(n >>> 16) & 0xFF] << 8) | // Reverse 3rd last 8 bits
        (lookupTable[(n >>> 24) & 0xFF]);       // Reverse first 8 bits
    }

    // main function
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
        Precompute reversed bits for all 0-255 (8-bit numbers) in a lookup table.
        Split n into 4 chunks of 8-bits each.
        Use table lookup to get the reversed value of each chunk.
        Reassemble the reversed chunks into the final 32-bit result.

        I still ain't confiden with Bit Manipulation.
 */