package dynamicProgramming;
import java.util.Arrays;

public class MinCostClimbingStairs {
    
    // Optimization 1: Top-Down DP (Recursion + Memoization)
    public static int minCostClimbingStairsTopDown(int[] cost) {
        int n = cost.length;
        int[] memo =  new int[n];
        Arrays.fill(memo, -1);  // Initialize memoization array with -1
        return Math.min(minCost(cost, n - 1, memo), minCost(cost, n - 2, memo));
    }
    private static int minCost (int[] cost, int i, int[] memo) {
        if ( i < 0)  return 0;
        if ( i == 0 || i == 1) return cost[i]; // Base case
        if (memo[i] != -1) return memo[i]; // Return if already computed
        
        // Store and return the minimum cost
        return memo[i] = cost[i] + Math.min(minCost(cost, i - 1, memo), minCost(cost, i - 2, memo));
    }

    // Optimization 2: Bottom-Up DP (Iterative DP)
    public static int minCostClimbingStairsBottomUp (int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Build DP table iteratively
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);  // The min cost to reach the top
    }

    // Optimization 3: Space-Optimized DP (O(1) space)
    public static int minCostClimbingStairsOptimized(int[] cost) {
        int n = cost.length;
        if (n == 0) return 0;
        if (n == 1) return cost[0];

        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = current;
        }
        return Math.min(prev1, prev2);  // The min cost to reach the top
    }

    // Driver code
    public static void main (String[] args) {
        int[] cost1 = {10, 15, 20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println("Top-Down DP:");
        System.out.println("Example 1: " + minCostClimbingStairsTopDown(cost1));
        System.out.println("Example 2: " + minCostClimbingStairsTopDown(cost2));

        System.out.println("\nBottom-Up DP:");
        System.out.println("Example 1: " + minCostClimbingStairsBottomUp(cost1));
        System.out.println("Example 2: " + minCostClimbingStairsBottomUp(cost2));

        System.out.println("\nOptimized DP (O(1) Space):");
        System.out.println("Example 1: " + minCostClimbingStairsOptimized(cost1));
        System.out.println("Example 2: " + minCostClimbingStairsOptimized(cost2));

    }
}

/**
 * 1. Top-Down DP (Recursion + Memoization)
        Uses recursion to break down the problem.
        Memoization (caching) prevents redundant calculations.
        Converts exponential complexity (O(2^n)) to linear (O(n)).
        Space Complexity: O(n) (due to recursion stack and memo array).
    2. Bottom-Up DP (Iterative DP)
        Eliminates recursion to avoid stack overflow issues.
        Uses a DP table to store previously computed results.
        Time Complexity: O(n).
        Space Complexity: O(n) (for the dp array).
    3. Space-Optimized DP (O(1) Space)
        Uses only two variables instead of an entire DP array.
        Iteratively computes the minimum cost without extra space.
        Time Complexity: O(n).
        Space Complexity: O(1) (constant space).
 */