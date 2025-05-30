
Leetcode 746: Min Cost Climbing Stairs
Author: Stuti Pandey
Date: May 24, 2025 (Third Edit)

🔶 Problem Statement (Leetcode 746)
You are given an integer array cost where cost[i] is the cost of i-th step on a staircase.
Once you pay the cost, you can either climb one or two steps.
You can start from step 0 or step 1.
Return the minimum cost to reach the top of the floor (past the last step).

Intuition:
This problem is essentially about finding the minimum cumulative cost to reach the end of a sequence, where you can move one or two steps at a time — very similar to shortest path problems.

Instead of focusing on reaching the top directly, I thought: how much does it cost to reach each step? Once I know that, the answer is just the minimum of the last two steps.

The key insight is that reaching step i depends only on steps i-1 and i-2. That makes it a classic bottom-up dynamic programming problem — with potential for O(1) space if we just store the last two values.



🔶 Constraints:
2 <= cost.length <= 1000

0 <= cost[i] <= 999

1. Top-Down DP (Recursion + Memoization)
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


The Fibonacci sequence is defined as:
fib(n) = fib(n - 1) + fib (n - 2)
Each number depends on the sum of the two previous ones.

but here, we are not summing, but instead we're taking the minimum of the two previous values and adding current cost:
dp[i] = cost[i] + min(dp[i - 1], dp[i - 2])

Yes, this reminds me of the Fibonacci pattern, where each step depends on the two previous ones. Instead of summing, I minimize between them and add cost. That similarity helped me decide to use an O(1) space DP solution, just like in space-optimized Fibonacci.

✅ 3. Real-Life Analogy / Examples
🔸 Escalator Cost Example
You're in a shopping mall, and every step on the escalator has an associated "energy cost." You can skip a step (like hopping two stairs at once), but still pay some cost. What’s the cheapest way to reach the top?

🔸 Fitness Tracking
Imagine a smartwatch calculates the minimum calories burned while going up stairs — and you can take one or two stairs at a time. You want to minimize effort. Same principle applies.

🔸 Mobile Game Design
In a platformer game, each tile costs energy to land on. The player can jump over tiles — either one or two. To reach the end while conserving energy, what's the best path?

