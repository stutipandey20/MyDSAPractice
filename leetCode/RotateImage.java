package leetCode;
import java.util.Arrays;

/*
 * LC: 48 Rotate Image
 * Topics: Arrays, Math, Matrix
 * 
 * Problem: You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
    DO NOT allocate another 2D matrix and do the rotation.

    Constraints:
    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000
 * 
 * Approach:
 * 1. Transpose
 * 2. Reverse 
 * 
 * Author: Stuti Pandey
 * Date: March 23, 2025
 */

public class RotateImage {
    // Rotates the matrix 90 degrees clockwise in-place
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        // Step 1: Transpose the matrix (swap elements across the diagonal)
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for(int i = 0; i < len; i++) {
            int start = 0;
            int end = len - 1;
            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start++] = matrix[i][end];
                matrix[i][end--] = temp;
            }
        }
    }

    // Utility method to print the matrix
    public void printMatrix(int[][] matrix) {
        for (int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    // Main method to test the rotation
    public static void main(String[] args) {
        RotateImage solution = new RotateImage();

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        solution.printMatrix(matrix);

        solution.rotate(matrix);

        System.out.println("Matrix after 90° clockwise rotation:");
        solution.printMatrix(matrix);
    }
}
