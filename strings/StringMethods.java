package strings;

/**
 * A Java program demonstrating commonly used String class methods.
 * 
 * Author: Stuti Pandey
 * Date: March 17, 2025
 */
public class StringMethods {
    public static void main(String[] args) {
        // Creating a String
        String str = "  Hello, Java World!  ";
        String anotherStr = "hello, java world!";

        // 1. Length of the string
        System.out.println("Length: " + str.length());

        // 2. Convert to Upper & Lower Case
        System.out.println("Upper Case: " + str.toUpperCase());
        System.out.println("Lower Case: " + str.toLowerCase());

        // 3. Trim (removes leading and trailing spaces)
        System.out.println("Trimmed: '" + str.trim() + "'");

        // 4. Substring
        System.out.println("Substring (7, 11): " + str.substring(7, 11));

        // 5. Character at specific index
        System.out.println("Character at index 7: " + str.charAt(7));

        // 6. Checking if the string contains a substring
        System.out.println("Contains 'Java': " + str.contains("Java"));

        // 7. Checking if two strings are equal
        System.out.println("Equals (case-sensitive): " + str.equals(anotherStr));
        System.out.println("Equals (ignore case): " + str.equalsIgnoreCase(anotherStr));

        // 8. Comparing strings lexicographically
        System.out.println("CompareTo: " + str.compareTo(anotherStr));
        System.out.println("CompareToIgnoreCase: " + str.compareToIgnoreCase(anotherStr));

        // 9. Replace characters or substrings
        System.out.println("Replace 'Java' with 'Python': " + str.replace("Java", "Python"));

        // 10. Split string into an array
        String[] words = str.split(" ");
        System.out.println("Split result:");
        for (String word : words) {
            System.out.println(word);
        }

        // 11. Checking if string starts or ends with a substring
        System.out.println("Starts with '  Hello': " + str.startsWith("  Hello"));
        System.out.println("Ends with 'World!  ': " + str.endsWith("World!  "));

        // 12. Finding index of a character or substring
        System.out.println("Index of 'J': " + str.indexOf('J'));
        System.out.println("Last index of 'o': " + str.lastIndexOf('o'));

        // 13. Checking if string is empty or blank
        String emptyStr = "";
        String blankStr = "   ";
        System.out.println("Is empty: " + emptyStr.isEmpty());
        System.out.println("Is blank: " + blankStr.isBlank());

        // 14. Joining strings
        String joined = String.join(" - ", "Hello", "World", "Java");
        System.out.println("Joined String: " + joined);

        // 15. Converting other types to String
        int num = 100;
        System.out.println("String value of int: " + String.valueOf(num));

        // 16. Convert String to char array
        char[] charArray = str.toCharArray();
        System.out.println("Character Array:");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        // 17. Format string
        String formatted = String.format("My name is %s and I am %d years old.", "John", 25);
        System.out.println("Formatted String: " + formatted);

        // 18. Concatenation
        System.out.println("Concatenated String: " + str.concat(" Welcome!"));

        // 19. Repeat a string multiple times (Java 11+)
        System.out.println("Repeated String: " + "Hello ".repeat(3));

        // 20. Escape characters in String
        String escaped = "This is a \"quoted\" text with newline\nand tab\tspaces.";
        System.out.println("Escaped String: " + escaped); 

    }
}
