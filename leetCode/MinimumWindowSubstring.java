package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

class MinimumWindowSubstring {

    /**
     * Finds the minimum window substring in 's' that contains all characters of 't'.
     * Uses the sliding window technique with two pointers for efficiency.
     *
     * @param s The source string.
     * @param t The target string containing required characters.
     * @return The minimum window substring containing all characters of 't', or an empty string if no such window exists.
     */

    private static final Logger logger = Logger.getLogger(MinimumWindowSubstring.class.getName());
    
    public static String minWindow (String s, String t) {
        // Edge cases: if input String is null or target string is longer than source
        if (s == null|| t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }
        
        // Step 1: Store character frequencies of 't' in a HashMap
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Initialize pointers and tracking variables
        int counter = 0;
        int  requiredChars = charCountMap.size();
        int left = 0;
        int  right = 0;
        int  minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        // Step 3: Sliding window approach
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            right++; // expand window

            // If the current character exists in 't', decrease it's count in map
            if (charCountMap.containsKey(currentChar)) {
                charCountMap.put(currentChar, charCountMap.get(currentChar) - 1);
                if (charCountMap.get(currentChar) == 0) {
                    counter++;
                }
            }

             // Step 4: Try to shrink the window from the left when all characters are matched
            while (counter == requiredChars) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }
                char startChar = s.charAt(left);
                left++;

                if (charCountMap.containsKey(startChar)) {
                    if (charCountMap.get(startChar) == 0) {
                        counter--; // A previously fully matched character is removed
                    }
                    charCountMap.put(startChar, charCountMap.get(startChar) + 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex +  minLen);

    }

    // main method
    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = MinimumWindowSubstring.minWindow(s, t);
        logger.info("Minimum Window Substring: " + result); // Expected output: "BANC"
    }

}