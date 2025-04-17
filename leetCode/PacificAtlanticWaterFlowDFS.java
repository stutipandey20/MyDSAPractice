package leetCode;
import java.util.*;

/*
 * LeetCode 417: Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 * DFS Approach
 * 
 * @author: Stuti Pandey
 * @date: April 16, 2025
 */

public class PacificAtlanticWaterFlowDFS {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int ROWS = heights.length;
        int COLS = heights[0].length;

        Set<String> pacSet = new HashSet<>();
        Set<String> atlSet = new HashSet<>();

        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, heights, pacSet, heights[r][0]);
            dfs(r, COLS - 1, heights, atlSet, heights[r][COLS - 1]);
        }

        for (int c = 0; c < COLS; c++) {
            dfs(0, c, heights, pacSet, heights[0][c]);
            dfs(ROWS - 1, c, heights, atlSet, heights[ROWS - 1][c]);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                String key = r + "," + c;
                if (pacSet.contains(key) && atlSet.contains(key)) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, int[][] heights, Set<String> visited, int prevHeight) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || heights[r][c] < prevHeight) {
            return;
        }

        String key = r + "," + c;
        if (visited.contains(key)) {
            return;
        }

        visited.add(key);

        dfs(r + 1, c, heights, visited, heights[r][c]);
        dfs(r - 1, c, heights, visited, heights[r][c]);
        dfs(r, c + 1, heights, visited, heights[r][c]);
        dfs(r, c - 1, heights, visited, heights[r][c]);
    }

    public static void main(String[] args) {
        
        PacificAtlanticWaterFlowDFS solver = new PacificAtlanticWaterFlowDFS();

        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };

        long startTime = System.nanoTime();

        List<List<Integer>> result = solver.pacificAtlantic(heights);

        long endTime = System.nanoTime();

        System.out.println("Cells that can reach both oceans: ");
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }

        System.out.println("Execution Time in DFS Approach: " + (endTime - startTime) / 1_000_000 + " ms");
    }
    
}
