package leetCode;
import java.util.*;

/**
 * 
 * Leetcode 994 - Rotting Oranges
 * 
 * Problem: Given an m x n grid where:
     * - 0 represents an empty cell
     * - 1 represents a fresh orange
     * - 2 represents a rotten orange
     * 
     * Every minute, any fresh orange adjacent to a rotten one becomes rotten.
     * The function returns the minimum number of minutes needed for all oranges 
     * to rot. If impossible, return -1.
     * 
     * Time Complexity: O(m * n) since each cell is processed at most once.
     * Space Complexity: O(m * n) for the queue storage in worst case.
 *  
 * @author Stuti Pandey
 * @date   2025-03-12
 */

public class RottingOranges {
    
    //
    public static int orangesRotting(int[][] grid) {

        // base cases
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Add all initial rotten oranges to the queue and count fresh oranges
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});   // Store position of rotten oranges
                } else if (grid[i][j] == 1) {
                    freshCount++; // Count fresh oranges
                }
            }
        } 

        // if there are no fresh oranges, return 0 (no time needed)
        if (freshCount == 0) {
            return 0;
        }
        
        // if there are fresh oranges, but not a single rotten orange, return -1 (impossible case)
        if (queue.isEmpty()) {
            return -1;
        }

        int minutes = 0;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // UP, RIGHT, LEFT, DOWN

        // Step 2: Perform BFS to rot fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for(int i = 0; i < size; i++) {
                int[] cell = queue.poll();

                // Check all four directions
                for(int[] dir : directions) {
                    int newRow = cell[0] + dir[0];
                    int newCol = cell[1] + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        // make it rotten
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[] { newRow, newCol });
                        freshCount--;   // Reduce fresh orange count
                        rotted = true;
                    }
                }
            }
            // If any orange rotted in this minute, increment time
            if (rotted) {
                minutes++;
            }
        }

        // Step 3: If there are still fresh oranges left, return -1, otherwise return time.
        return freshCount == 0 ? minutes : -1;
    }

    // Main function to test the solution and measure execution time
    public static void main(String[] args) {

        int[][] grid1 = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        long startTime = System.nanoTime();
        int result = orangesRotting(grid1);
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("Output 1: " + result);
        System.out.println("Execution Time: " + executionTime + " ms");
        
        // int[][] grid2 = {
        //     {2, 1, 1},
        //     {0, 1, 1},
        //     {1, 0, 1}
        // };

        int[][] grid2 = new int[][] {{0, 2}};
        
        startTime = System.nanoTime();
        result = orangesRotting(grid2);
        endTime = System.nanoTime();
        executionTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("Output 1: " + result);
        System.out.println("Execution Time: " + executionTime + " ms");

    }
}

/**
 * 
 * Why did we use BFS and not DFS?
 * Both BFS and DFS could technically solve this problem. Still BFS is preferred because:
 * BFS processes all nodes at a given distance from the source before moving to nodes that are farther away. 
 * In this rotting oranges problem, this property is crucial because:
 * 
 * Each "level" of the BFS corresponds directly to one minute of time elapsed
 * We want to find the minimum number of minutes required, which is essentially asking 
 * for the shortest path from any rotten orange to all fresh oranges
 * 
 * If we used DFS:
    It would follow one path all the way to the end before backtracking
    This depth-first approach doesn't naturally track the "levels" or "time"
    We'd need additional complexity to track the minimum time required to rot each fresh orange
 * 
 * Think of how rotting spreads in real life - it happens in all directions simultaneously, not one path at a time. 
 * BFS mimics this natural spreading pattern, with each level of the search representing one minute of time passing.
 * That said, DFS could be made to work with some modifications:
    You would need to track the minimum time to rot each fresh orange
    After the DFS completes, you'd need to find the maximum of these times
    This approach would be more complex and less intuitive than BFS

So while both approaches can technically solve the problem, BFS provides a more natural fit 
where the level-by-level exploration directly maps to the time elapsed in the problem statement.
 * 
 */
