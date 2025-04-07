package arrays;

/**
 * LeetCode 41: Find Missing Positive
 * Finds the first missing positive integer in an unsorted array.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * 
 * @author Stuti Pandey
 * @date April 6, 2025
 */

public class FindMissingPositive {

    /*
     * @param nums The input array containing integers.
     * @return The smallest missing positive integer.
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct index (i.e., value 3 should be at index 2)
        for (int i = 0; i < n; i++) {
            // While nums[i] is in range [1, n] and not in its correct position, swap it
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with the number at its target position
                int correctIndex = nums[i] - 1;
                int temp = nums[correctIndex];
                nums[correctIndex] = nums[i];
                nums[i] = temp; 
            }
        }
         
        // Step 2: Find the first index where the value is not i + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // This is the missing positive integer
            }
        }

        return n + 1;
    }

     /**
     * Sample usage and test cases for the firstMissingPositive method.
     */
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 0},              // Expected: 3
            {3, 4, -1, 1},          // Expected: 2
            {7, 8, 9, 11, 12},      // Expected: 1
            {1},                    // Expected: 2
            {2, 1},                 // Expected: 3
            {1, 1}                  // Expected: 2
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = firstMissingPositive(testCases[i]);

            System.out.println("Test Case " + (i + 1) + ": Missing = " + result);
        }
    }
}
