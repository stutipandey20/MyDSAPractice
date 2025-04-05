package arrays;

import java.util.*;

/**
 * Leetcode Problem: 57. Insert Interval
 * Question:
 * You are given an array of non-overlapping intervals `intervals` where each interval is [start, end],
 * and sorted in ascending order by start. You are also given a new interval `newInterval`.
 *
 * Insert `newInterval` into `intervals` such that the list remains sorted and non-overlapping,
 * merging if necessary.
 *
 * Return the resulting list of intervals.
 * 
 * Type: Array
 * 
 * Approach:
 * 1. Linear Search
 * 2. Binary Search
 * 
 * Time Complexity: O(n) - each interval is visited once
 * Space Complexity: O(n) - result list stores up to all intervals
 * 
 * Author: Stuti Pandey
 * Date: April 5, 2025
 */

public class InsertInterval {

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        // Null or invalid interval
        if (newInterval == null || newInterval.length != 2) {
            return intervals != null ? intervals : new int[0][];
        }

        // Null or empty intervals
        if (intervals == null || intervals.length == 0) {
            result.add(newInterval);
            return result.toArray(new int[1][2]);
        }

        int i = 0, n = intervals.length;

        // Add all intervals before newInterval (No Overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Now merge overlapping intervals with newInterval by updating the values, post comparison
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);    // Add merged interval

        // Add the remaining elements to the result array
        while(i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    private static void printResult(int[][] intervals, int[] newInterval) {
        int[][] result = insertInterval(intervals, newInterval);
        System.out.println("Merged Intervals:");

        for (int[] interval: result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        // Example Test Case 1: Normal merge
        int[][] intervals1 = { {1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16} };
        int[] newInterval1 = {4, 8};
        printResult(intervals1, newInterval1);

        // Example Test Case 2: Empty intervals
        int[][] intervals2 = {};
        int[] newInterval2 = {5, 7};
        printResult(intervals2, newInterval2);

        // Example Test Case 3: newInterval null
        int[][] intervals3 = { {1, 3}, {6, 9} };
        int[] newInterval3 = null;
        printResult(intervals3, newInterval3);

        // Example Test Case 4: All intervals after newInterval
        int[][] intervals4 = { {10, 15}, {20, 25} };
        int[] newInterval4 = {1, 5};
        printResult(intervals4, newInterval4);
        
    }
}

/**
 * 
 * Edge cases to handle:
    * intervals is null or empty
    * newInterval is null or malformed (length ≠ 2)
    * All intervals are after or before newInterval
    * newInterval does not overlap with any interval
 * 
 * 
 * 
 */
