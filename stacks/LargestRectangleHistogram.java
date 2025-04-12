package stacks;
import java.util.Stack;

/**
 * Leetcode 84: Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Author: Stuti Pandey
 * Date: April 12, 2025
 *
 * Description:
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 *
 * Constraints:
 * - 1 <= heights.length <= 10^5
 * - 0 <= heights[i] <= 10^4
 */

public class LargestRectangleHistogram {

    /*
     * Computes the largest rectangle area in a histogram using a monotonic increasing stack.
     * 
     * @param heights Array of bar heights in the histogram
     * @return The maximum area of a rectangle that can be formed
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // Append a zero th heights to flush out all the bars at the end (for ex- [2, 4])
        int[] extended = new int[heights.length + 1];
        System.arraycopy(heights, 0, extended, 0, heights.length);
        extended[heights.length] = 0;

        for (int i = 0; i < extended.length; i++) {
            // Maintain the stack in increasing order of bar heights
            while (!stack.isEmpty() && extended[stack.peek()] > extended[i]) {
                int height = extended[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, (height * width));
            }
            stack.push(i); // push the current index onto the stack
        }

        return maxArea;
    }
    public static void main(String[] args) {
        LargestRectangleHistogram solver = new LargestRectangleHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};

        int result = solver.largestRectangleArea(heights);
        System.out.println("Largest Rectangle Area: " + result);

    }
}
/*
 * A brute-force approach would check all pairs (i, j) and compute the min height between them, resulting in O(n²) time.
 *  New concept: Monotonic Increasing Stack
 * A monotonic increasing stack is a stack where:
 * The values (or the values at the indices in the stack) are in non-decreasing order from bottom to top.
 * So, each new element pushed must be greater than or equal to the one before it.
 * 
 * Can be used to:
 * 1. Efficiently track boundaries (like in histograms, rain water problems, etc.)
 * 2. Maintain a useful order while scanning once (O(n))
 * 3. Find the next/previous smaller or greater element
 * 
 * I added a 0 at the end to flush the stack and ensure all areas are computed.This runs in O(n) time, which is optimal.
 * 
 * Edge case: What if all bars have the same height? e.g., [3,3,3,3,3]
 * Answer: The stack will keep pushing as all values are equal or increasing. 
 * When we hit the sentinel 0, we start popping. We’ll get a max area of 3 * 5 = 15, which is correct.
 * 
 * How does the code behave for an input like [1,2,3,4,5]?
 * All bars are increasing, so the stack will keep pushing. Only at the end (due to 0), we pop and compute each area.
 * Max area would be 3 * 3 = 9 for the center bar.
 * 
 * Another way with having an extended array -> inside for loop ahve a check int h = (i == len ? 0 : heights[i]);
 */