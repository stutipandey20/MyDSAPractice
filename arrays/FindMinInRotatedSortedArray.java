package arrays;

/**
 * Leetcode 153: Find Minimum in Rotated Sorted Array
 *
 * Constraints:
 * - 1 <= nums.length <= 5000
 * - -5000 <= nums[i] <= 5000
 * - All elements are unique
 * - The array is sorted in ascending order and rotated between 1 and n times
 *
 * Time Complexity: O(log n) - due to binary search
 * Space Complexity: O(1) - constant extra space
 *
 * @author Stuti Pandey
 * @date April 6, 2025
 */

public class FindMinInRotatedSortedArray {

    /**
     * 
     * @param nums - rotated sorted array of unique integers
     * @return the minimum element in the array
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search for the minimum element
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right, minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {    // Else, the minimum is in the left half including mid
                right = mid;
            }
        }

        // At the end of loop, left == right, pointing to the minimum
        return nums[left];
    }

    /*
     * Main method with test cases to validate the solution
     */
    public static void main (String[] args) {
        int[][] testCases = {
            {3, 4, 5, 1, 2},       // Output: 1
            {4, 5, 6, 7, 0, 1, 2}, // Output: 0
            {11, 13, 15, 17},      // Output: 11
            {2, 1},                // Output: 1
            {1},                   // Output: 1
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = findMin(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ": Minimum = " + result);
        }
    }
}
/**
 * Some potential follow-ups:
 * 
 * 1. What is the array contains duplicates?
 * => In such cases, BS can't always decide which half is sorted based on 
 * nums[mid] and nums[right]
 * 
 * Solution
 * if (nums[mid] == nums[right]) {
    right--; // safely shrink the search space
}
 * Time complexity will degrade to O(n) in worst-case
 * 
 * 2. Can we solve it recursively?
 * Yes, but doing that will increase call stack space.
 * 
 * 3. What if the array was rotated but not sorted originally?
 * => Binary search relies on a sorted array. 
 * If the original array isn't sorted before rotation, this approach fails. 
 * We'd need a linear scan
 * 
 * 4. What if the array is rotated zero times?
=> easiest. Because the array is still sorted — and the first element is the minimum.

5. Index of the minimum element, not just the value?
=> return left, instead of nums[left] at the end.@interface
 * 
 * 
 * 6. Find how many times the array was rotated?
 * => Yes. It's simply the index of the minimum element.
 * int rotationCount = indexOfMin; // Same as left at the end of binary search
 */