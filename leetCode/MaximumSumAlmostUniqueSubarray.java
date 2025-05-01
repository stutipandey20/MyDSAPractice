package leetCode;
import java.util.*;
/*
 * Leetcode: 2841. Maximum Sum of Almost Unique Subarray
 * 
 * @author: Stuti Pandey
 * @date May 1 2025
 */

public class MaximumSumAlmostUniqueSubarray {

    public static long maxSum(List<Integer> nums, int m, int k) {

        if (Objects.isNull(nums) || nums.size() == 0 || nums.size() < k || m > k) {
            return 0;
        }

        long maxSum = 0, windowSum = 0;
        int left = 0, size = nums.size();
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

        for (int right = 0; right < size; right++) {
            int num = nums.get(right);
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            windowSum += num;

            while (right - left + 1 > k) {
                int remove = nums.get(left);
                left++; // move the left pointer forward
                freqMap.put(remove, freqMap.get(remove) - 1);
                if (freqMap.get(remove) == 0) {
                    freqMap.remove(remove);
                }
                windowSum -= remove;
            }

            if (right - left + 1 == k) {
                // we have the window we need
                if (freqMap.size() >= m) {
                    maxSum = Math.max(maxSum, windowSum);
                }
            }
        }

        return maxSum;
    }
    
    public static void main(String [] args) {
        /*
         * Example 1 from LeetCode: nums = [2,6,7,3,1,7], m = 3, k = 4
         * Answer: 18
         */
        List<Integer> nums1 = new ArrayList<>();
        Collections.addAll(nums1, 2, 6, 7, 3, 1, 7);
        int m1 = 3, k1 = 4;
        System.out.println("Max sum (Test 1): " + maxSum(nums1, m1, k1)); // Output: 18

        /*
         * Example 2 from LeetCode: nums = [5,9,9,2,4,5,4], m = 1, k = 3
         * Answer: 23
         */
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(5, 9, 9, 2, 4, 5, 4));
        int m2 = 1, k2 = 3;
        System.out.println("Max sum (Test 2): " + maxSum(nums2, m2, k2)); // Output: 23

         /*
          * Example 3 from LeetCode: nums = [1,2,1,2,1,2,1], m = 3, k = 3
          * Answer: 0 (there are no subarrays of size = 3 that contain at least m = 3 distinct elements in the given subarray)
          */
        List<Integer> nums3 = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1, 2, 1));
        int m3 = 3, k3 = 3;
        System.out.println("Max sum (Test 3): " + maxSum(nums3, m3, k3)); // Output: 0

        /*
         * Example 4: 
         */
        List<Integer> nums4 = Arrays.asList(1, 1, 1, 3, 3, 3, 5, 5, 5);
        int m4 = 2, k4 = 3;
        System.out.println("Max sum (Test 4): " + maxSum(nums4, m4, k4)); // Output: 11

        
    }
}
