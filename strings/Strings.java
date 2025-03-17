package strings;
import java.nio.charset.Charset;

/*
 * String basic methods implementation from GFG - different type of constructors
 * https://www.geeksforgeeks.org/string-class-in-java/
 * 
 * Author: Stuti Pandey
 * Date: March 17, 2025
 */

public class Strings {

    // Variables in Methods
    static byte[] bArr = {71, 101, 101, 107, 115};
    static Charset cs = Charset.defaultCharset();
    static char[] charArr = {'G', 'e', 'e', 'k', 's'};
    static int[] uniCode = {71, 101, 101, 107, 115};
    static StringBuffer sBuffer = new StringBuffer("Geeks");
    static StringBuilder sBuilder = new StringBuilder("Geeks");

    public static void main(String[] args) {
        // Method 1
        String s1 = new String(bArr);
        System.out.println("Method 1: " + s1);
        System.out.println();

        // Method 2
        String s2 = new String(bArr, cs);
        System.out.println("Method 2: " + s2);
        System.out.println();

        // This is alternative way for Method 2
        String s3 = new String(bArr, Charset.forName("US-ASCII"));
        System.out.println("Method 2 Alternative: " + s3);
        System.out.println();

        // Method 3
        String s4 = new String(bArr, 1, 3);
        System.out.println("Method 3: " + s4);
        System.out.println();

        // Method 4
        String s5 = new String(bArr, 1, 3, cs);
        System.out.println("Method 4: " + s5);
        System.out.println();
        
        // This is alternative way for Method 4
        String s6 = new String(bArr, 1, 4, Charset.forName("US-ASCII"));
        System.out.println("Method 4 Alternative: " + s6);
        System.out.println();
        
        // Method 5
        String s7 = new String(charArr);
        System.out.println("Method 5: " + s7);
        System.out.println();
        
        // Method 6
        String s8 = new String(charArr, 1, 3);
        System.out.println("Method 6: " + s8);
        System.out.println();
        
        // Method 7
        String s9 = new String(uniCode, 1, 3);
        System.out.println("Method 7: " + s9);
        System.out.println();

        // Method 8
        String s10 = new String(sBuffer);
        System.out.println("Method 8: " + s10);
        System.out.println();

        // Method 9
        String s11 = new String(sBuilder);
        System.out.println("Method 9: " + s11);
        System.out.println();
    }
    
}
