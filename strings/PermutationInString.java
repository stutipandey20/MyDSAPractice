package strings;

/**
 * Leetcode 567: Permutation in String
 * Author: Stuti Pandey
 * Date: April 6, 2025
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1.
 * In other words, check if s2 contains a substring that is a permutation of s1.
 *
 * Time Complexity: O(n) - where n = s2.length()
 * Space Complexity: O(1) - fixed size 26 for lowercase letters
 */

public class PermutationInString {
    
    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Build frequency of s1
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        int windowSize = s1.length();

        // Build initial window
        for (int i = 0; i < windowSize; i++) {
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // check for matches
        if (matches(s1Freq, windowFreq)) {
            return true;
        }

        for (int i = windowSize; i < s2.length(); i++) {
            windowFreq[s2.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i - windowSize) - 'a']--;

            if (matches(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }

    private static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println("Test 1 (Expected: true): " + checkInclusion(s1, s2));

        // Test Case 2
        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println("Test 2 (Expected: false): " + checkInclusion(s1, s2));

        // Test Case 3: exact match
        s1 = "abc";
        s2 = "cba";
        System.out.println("Test 3 (Expected: true): " + checkInclusion(s1, s2));

        // Test Case 4: permutation at the end
        s1 = "adc";
        s2 = "dcda";
        System.out.println("Test 4 (Expected: true): " + checkInclusion(s1, s2));

        // Test Case 5: s1 longer than s2
        s1 = "abcd";
        s2 = "abc";
        System.out.println("Test 5 (Expected: false): " + checkInclusion(s1, s2));
    }
}
/**
 * Tracked character frequency using an array of size 26.
 * For each window in s2, compared its frequency with that of s1. 
 * This approach runs in O(n) time and constant space, which is optimal given the constraints of lowercase letters.
 * 
 * Follow-ups:
 * 
 * Question: What if input contains uppercase, symbols, or unicode?
 * Answer: You can’t use int[26] anymore. use a HashMap<Character, Integer> instead.
 * 
 * Question: What if you need to return all substrings in s2 that are permutations of s1?
 * Answer: Instead of returning true, collect the start indices where matches() returns true.
 * 
 * Question: What if you're working on a stream of characters?
 * Answer: You process characters one by one and maintain a sliding window on-the-fly (real-time string stream).
 */