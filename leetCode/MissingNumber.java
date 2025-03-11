package leetCode;
import java.util.Arrays;

/**
 * Leetcode 268: Missing Number
 * Author: Stuti Pandey
 * Date: March 10, 2025
 * 
 * Problem Statement:
 * Given an array nums containing n distinct numbers in the range [0, n], 
 * return the only number missing from the array.
 * 
 * Constraints:
 * - n == nums.length
 * - 1 <= n <= 10^4 
 * - 0 <= nums[i] <= n
 * - All the numbers of nums are unique.
 * 
 * Follow-up: Can you implement a solution using O(1) extra space and O(n) runtime?
 */

public class MissingNumber {
    
    public MissingNumber() {}

    /**
     * ✅ XOR Approach (O(n) time, O(1) space)
     * - Uses the property: a ^ a = 0 and a ^ 0 = a
     * - Efficient, requires no extra space
     */
    public static int missingNumberXOR(int[] nums) {
        int n = nums.length;
        int xor = 0;

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }

        // XOR all elements in the array
        for (int num : nums) {
            xor ^= num;
        }

        // The remaining number is the missing one
        return xor;
    }

    /**
     * ✅ Binary Search Approach (O(n log n) time, O(1) space)
     * - Sorts the array first
     * - Uses binary search to find the missing number
     */
    public static int missingNumberBinarySearch(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // if nums[mid] == mid, missing number is on the right
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // The left index will be the missing number
        return left; 
    }

    // main function to test all solutions
    public static void main(String[] args) {
        int[][] testCases = {
            {3, 0, 1},       // Expected Output: 2
            {0, 1},          // Expected Output: 2
            {9, 6, 4, 2, 3, 5, 7, 0, 1}, // Expected Output: 8
            {1}              // Expected Output: 0
        };

        System.out.println("Testing XOR Approach:");
        for (int[] test : testCases) {
            System.out.println("Missing number: " + missingNumberXOR(test));
        }

        System.out.println("\nTesting Binary Search Approach:");
        for (int[] test : testCases) {
            System.out.println("Missing number: " + missingNumberBinarySearch(test));
        }
    }
}
/**
 * 
 * 📌 Explanation of Approaches
    🔹 1️⃣ XOR Approach (O(n) time, O(1) space)
        Uses XOR properties:
        a ^ a = 0
        a ^ 0 = a
        Steps:
        XOR all numbers from 0 to n.
        XOR all elements in nums[].
        The remaining number is the missing one.
        ✅ Best for large inputs since it is O(n) time & O(1) space.

    🔹 2️⃣ Binary Search Approach (O(n log n) time, O(1) space)
        Steps:
        Sort the array (O(n log n)).
        Perform binary search:
        If nums[mid] == mid, search in the right half.
        Otherwise, search in the left half.
        The left pointer will be at the missing number.
        ❌ Slower than XOR due to sorting (O(n log n)).
 */