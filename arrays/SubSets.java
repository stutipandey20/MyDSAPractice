package arrays;
import java.util.*;

/**
 * 
 * LeetCode 78: Subsets
 * 
 * Problem Description: Given a set of distinct integers, return all possible subsets.
 * 
 * This is simpler than LC 90 because we don’t worry about duplicates. 
 * We can use either recursion (backtracking) or an iterative solution.
 * 
 * @author: Stuti Pandey
 * @date: April 9, 2025
 */
public class SubSets {
    
    public List<List<Integer>> getSubsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();

        backtrack(resultList, new ArrayList<>(), nums, 0);

        return resultList;
    }

    private void backtrack(List<List<Integer>> resultList, List<Integer> currentSubset, int[] nums, int start) {
        resultList.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            currentSubset.add(nums[i]);

            backtrack(resultList, currentSubset, nums, i + 1);

            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSets subSet = new SubSets();

        int[] nums = {1,2,3};

        List<List<Integer>> result = subSet.getSubsets(nums);

        // print results
        for (List<Integer> sub : result) {
            System.out.print(sub);
        }
    }
}
