package arrays;
import java.util.*;

/*
 * LeetCode 90: Subsets II
 * 
 * Problem Description: Given an integer array, nums, that may contain duplicates,
 * return all possible subsets (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * 
 * Topics: Array, Backtracking, Bit Manipulation
 * 
 * Approach: Backtracking
 * 
 * To avoid duplicates, sort the input array first.
 * Doing this - duplicate elements are adjacent to each other.
 * 
 * Time Complexity: O(2^n): In the worst case, we generate all subsets, where n is the number of elements in the input list.
 * Space Complexity: O(n): The space used for the recursion stack and to store the subsets.
 * 
 * @author: Stuti Pandey
 * @date: April 9, 2025
 */

public class SubSetsII {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);      // Sort to handle duplicates
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {

        // Add the current subset to the result
        result.add(new ArrayList<>(currentSubset));

        // Backtrack to generate the subsets
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates: if the current element is the same as the previous one, skip it
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include nums[i] in the current subset
            currentSubset.add(nums[i]);

            // move to the next element
            backtrack(result, currentSubset, nums, i + 1);

            // backtrack by removing the last element
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSetsII subSetsII =  new SubSetsII();

        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = subSetsII.subsetsWithDup(nums);

        // display the result
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
/*
 * 1. Sorting
 * 2. Backtracking
 * 3. Avoiding Duplicates:
 * 4. Result
 * 
 * Brute Force:
 * generating all possible subsets using a recursive or backtracking approach
 * 
 * Since the input array can contain duplicates, the brute-force approach would generate duplicate subsets, 
 * which isn't allowed
 * 
 * To fix this, sort the input array first. That way, all duplicates are adjacent. 
 * This makes it easier to detect and skip duplicates during subset generation
 * 
 * While backtracking, for each recursive call, skip over elements that were the same as the previous one unless it was the first occurrence at that level of recursion. 
 * Use the condition if (i > start && nums[i] == nums[i - 1]) continue; to skip processing duplicate elements
 * 
 * So, the final approach uses backtracking with sorted input and a condition to skip duplicate elements at the same recursive level. 
 * This ensures all subsets are unique, and we avoid the extra space/time needed for a HashSet or post-processing
 * 
 * Question: can we do this without modifying the input array (i.e., no sorting)?
 * AnsweR: Yes, but skipping duplicates becomes harder without sorting. I'd likely need a HashSet to track seen subsets, which adds overhead. 
 * Sorting is the cleaner and more efficient way to manage duplicates.
 * 
 * Questions: What if the problem asks for subsets of exactly size k?
 * Answer: I'd add a check inside the recursive function to only add subsets of length k. 
 * And if the current subset exceeds k, I'd return early to prune the recursion
 */
