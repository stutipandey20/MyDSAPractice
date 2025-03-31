package arrays;
import java.util.*;

/**
 * Leetcode 56: Merge Intervals
 * Author: Stuti Pandey
 * Date: March 31, 2025
 * 
 * Given an array of intervals, where intervals[i] = [starti, endi], merge all overlapping intervals, 
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * 
 * Constraints:
1 <= intervals.length <= 10⁴
intervals[i].length == 2
0 <= starti <= endi <= 10⁴

 */
public class MergeIntervals {
    
    // Method to merge overlapping intervals
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Create a list to store merged intervals
        List<int[]> result = new ArrayList<>();

        // Step 3: Add the first interval to the result
        int[] current = intervals[0];
        result.add(current);

        // Step 4: Iterate through the intervals and merge where necessary
        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = current[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (currentEnd >= nextStart) {
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                current = intervals[i];
                result.add(current);
            }
        }

        // Step 5: Convert result list to int[][]
        return result.toArray(new int[result.size()][]);
    }

    // Main method to test the merge function
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();

        // Sample input
        int[][] intervals = {
            {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        // int[][] intervals2 = {
        //     {1, 4}, {4, 5}
        // };

        // call merge method
        int[][] merged = mergeIntervals.merge(intervals);

        // Print the merge intervals
        System.out.println("New Merged Intervals:");
        for(int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

/*
 * Tips to Solve the problem
 * 1. Sort the Intervals based on the start time (intervals[0])
 * 2. Initialize a merged list -> add the first interval to the list, the for each interval, compare its start with the end of previous one
 * 3. Merge or Append -> if currentStart <= lastEnd: merge -> lastEnd = Math.max(currentEnd, lastEnd)
 * 4. Use a List<int[]> for optimal memory use.
 */
