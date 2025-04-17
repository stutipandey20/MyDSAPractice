package leetCode;

import java.util.*;
import java.util.logging.Logger;
import java.util.logging.Level;


/*
 * LeetCode 417: Pacific Atlantic Water Flow
 * https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 * BFS Approach
 * 
 * @author: Stuti Pandey
 * @date: April 16, 2025
 */
public class PacificAtlanticWaterFlowBFS {

    private static final Logger logger = Logger.getLogger(PacificAtlanticWaterFlowBFS.class.getName());

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for (int r = 0; r < ROWS; r++) {
            pacQueue.offer(new int[] {r, 0});
            atlQueue.offer(new int[] {r, COLS - 1});
            pacific[r][0] = true;
            atlantic[r][COLS - 1] = true;
        }

        for (int c = 0; c < COLS; c++) {
            pacQueue.offer(new int[] {0, c});
            atlQueue.offer(new int[] {ROWS - 1, c});
            pacific[0][c] = true;
            atlantic[ROWS - 1][c] = true;
        }

        bfs(heights, pacQueue, pacific);
        bfs(heights, atlQueue, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void bfs (int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] direction: directions) {
                int nr = r + direction[0];
                int nc = c + direction[1];
                
                if (nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS) {
                    continue;
                }

                if (visited[nr][nc] || heights[nr][nc] < heights[r][c]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }
    }
    
    public static void main(String[] args) {

        PacificAtlanticWaterFlowBFS solver = new PacificAtlanticWaterFlowBFS();

        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };

        long startTime = System.currentTimeMillis();
        long startTimeNano = System.nanoTime(); 

        List<List<Integer>> result = solver.pacificAtlantic(heights);

        long endTime = System.currentTimeMillis();
        long endTimeNano = System.nanoTime();

        System.out.println("Cells that can reach both oceans:");
        for (List<Integer> cell : result) {
            System.out.println(cell);
        }

        logger.log(Level.INFO, "Execution Time: {0} ms", (endTime - startTime));  // giving 0 ms outcome as code execution too quick
        long durationInMillis = ((endTimeNano - startTimeNano) / 1_000_000);
        logger.log(Level.INFO, "Execution Time: {0} ms", durationInMillis / 100);
    }
}
