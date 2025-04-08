package arrays;

/**
 * LeetCode 74: Search a 2D Matrix
 * 
 * Problem Description:
 * You are given an m x n integer matrix `matrix` with the following two properties:
 *  1. Each row is sorted in non-decreasing order.
 *  2. The first integer of each row is greater than the last integer of the previous row.
 *
 * Given an integer `target`, return true if target is in `matrix`, or false otherwise.
 * 
 * Your solution must run in O(log(m * n)) time complexity.
 *
 * Constraints:
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= m, n <= 100
 * - -10^4 <= matrix[i][j], target <= 10^4
 * 
 * @author Stuti Pandey
 * @date April 7, 2025
 */

public class Search2DMatrix {
    
    /**
     * Performs binary search on a 2D matrix.
     * Treats the 2D matrix as a 1D sorted array by index conversion.
     *
     * @param matrix the input 2D matrix where each row is sorted and the first element of a row > last of previous
     * @param target the value to search for
     * @return true if target is found, false otherwise
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Perform binary search on the "flattened" 1D version of the matrix
        int left = 0;
        int right = rows * cols - 1;

        // Binary search on the flattened matrix
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Convert the 1D mid index back to 2D coordinates
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    /*
     * Runs test cases for searchMatrix method
     */
    public static void main(String[] args) {
        int[][] matrix1 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        // Test various target values
        int target1 = 3;
        int target2 = 13;
        int target3 = 60;
        int target4 = 1;
        int target5 = 100;

        // Output results for each test
        System.out.println("Test Case 1: " + searchMatrix(matrix1, target1)); // true
        System.out.println("Test Case 2: " + searchMatrix(matrix1, target2)); // false
        System.out.println("Test Case 3: " + searchMatrix(matrix1, target3)); // true
        System.out.println("Test Case 4: " + searchMatrix(matrix1, target4)); // true
        System.out.println("Test Case 5: " + searchMatrix(matrix1, target5)); // false
    }
}
/**
 * 
 * Some potential follow-up questions:
 * 
 * 1. What if the matrix doesn’t have the “row-start > previous row-end” guarantee?
 * => in this case, we can't treat the matrix like a sorted 1D array anymore.
 * 
 * perform a 2 step search
 * Binary search each row to find which row the target could be in.
 * Binary search that row for the target.
 * Time complexity: O(log m + log n)
 * 
 * 2. What if each row is sorted but columns aren't, and rows don't follow any specific pattern?
 * Binary search each row individually → O(m log n)
 * Or linear scan if matrix is very small.
 * 
 * 
 * 
 */