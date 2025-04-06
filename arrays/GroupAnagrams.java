package arrays;

import java.util.*;

/**
 * LeetCode 49: Group Anagrams
 * 
 * Solution class to group anagrams from an array of strings.
 * Uses a HashMap to store and retrieve anagram groups efficiently.
 */

class GroupAnagrams {

    /**
     * Groups anagrams from the given list of strings.
     * @param strs Array of input strings.
     * @return List of anagram groups.
     */

     public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store sorted character frequencies as keys and anagram groups as values
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Generate a unique key based on character frequencies
            String key = generateKey(str);

            // If key does not exist, create a new list for this anagram group
            map.putIfAbsent(key, new ArrayList<>());

            // Add the current string to its respective anagram group
            map.get(key).add(str);
        }
        
        // Return all anagram groups as a list of lists
        return new ArrayList<>(map.values());
    }

    /**
     * Generates a key for the anagram by counting character frequencies.
     * @param str Input string.
     * @return A unique key representing the character frequency.
     */
    private String generateKey(String str) {
        int[] charCount = new int[26];  // Array to store frequency of each character (a-z)
        
        // Count occurrences of each character in the string
        for (char ch : str.toCharArray()) {
            charCount[ch - 'a']++;
        }

        // Convert character count array to a unique string key
        StringBuilder keyBuilder = new StringBuilder();
        for (int count : charCount) {
            keyBuilder.append(count).append("#");  // Append each count with a separator
        }
        
        return keyBuilder.toString();
    }

    /**
     * Main method for testing the groupAnagrams function.
     */
    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();

        // Example test case
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Call the function and print results
        List<List<String>> result = obj.groupAnagrams(words);

        System.out.println("Grouped Anagrams: " + result);
    }
    
}
