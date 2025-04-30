package general;
import java.math.BigInteger;

/*
 * @author: Stuti Pandey
 * @date: April 29, 2025
 * 
 * This program counts how many integers less than or equal to A are divisible by both B and C.
 * The integers that satisfy this condition are multiples of the Least Common Multiple (LCM) of B and C.
 * The solution uses GCD (Greatest Common Divisor) to calculate LCM and counts the multiples of LCM that are <= A.
 * 
 * Time complexity: O(log(min(B, C)))
 * Space Complexity: O(1)
 */

public class SpecialIntegers {

    /*
     * Function to calculate GCD (Greatest Common Divisor) of two numbers using Euclidean algorithm.
     * 
     * @param a First number
     * @param b second number
     * @return The GCD of a and b
     */
    public static int gcd (int b, int c) {
        // Using BigInteger's gcd method to calculate GCD for large integers
        return BigInteger.valueOf(b).gcd(BigInteger.valueOf(c)).intValue();
    }

    /*
     * Function to calculate LCM (Least Common Multiple) of two numbers.
     * 
     * @param b The First number
     * @param c The second number
     * @return The LCM of b and c
     */
    public static int lcm(int b, int c) {
        // LCM is calculated using the formula LCM(b, c) = (b * c) / gcd(b, c)
        return (b * c) / gcd(b, c);
    }

     /*
      * Function to count how many multiples of LCM are less than or equal to A.
      * These multiples are the "special integers"
      * @param A Upper bound (inclusive)
      * @param B Divisor 1
      * @param C Divisor 2
      * @return The count of special integers <= A
      *
      */
    public static int countSpecialIntegers(int a, int b, int c) {

        // find the LCM of B and C
        int lcmValue = lcm(b, c);

        // Count how many multiples of lcmValue are <= a
        // Integer division to get the count of multiples
        return a / lcmValue;
    }
    
    public static void main(String[] args) {
        // Example input values
        int A = 100; // upper bound
        int B = 4; // Divisor 1
        int C = 6; // Divisor 2

        // Call the countSpecialIntegers function and display the result
        System.out.println("Special integers count: " + countSpecialIntegers(A, B, C));
    }
    
}
