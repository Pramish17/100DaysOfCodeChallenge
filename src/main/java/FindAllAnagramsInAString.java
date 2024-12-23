import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        // Result list to store starting indices of anagrams
        List<Integer> result = new ArrayList<>();

        // Edge case: If `s` is empty or null, return an empty list
        if (s == null || s.length() == 0) return result;

        // Frequency array to count characters in `p`
        int[] charCounts = new int[26];
        for (char c : p.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Sliding window pointers and count of characters to match
        int left = 0, right = 0, count = p.length();

        // Traverse through the string `s` using the sliding window
        while (right < s.length()) {
            // Decrease count for the current character in the window
            if (charCounts[s.charAt(right) - 'a']-- >= 1) {
                count--;
            }
            right++; // Expand the window

            // If all characters match, add the starting index to the result
            if (count == 0) {
                result.add(left);
            }

            // Shrink the window when the size exceeds `p.length()`
            if (right - left == p.length()) {
                if (charCounts[s.charAt(left) - 'a']++ >= 0) {
                    count++;
                }
                left++; // Move the left pointer
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString solution = new FindAllAnagramsInAString();

        // Test Case 1
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println("Anagrams starting indices: " + solution.findAnagrams(s1, p1));

        // Test Case 2
        String s2 = "abab";
        String p2 = "ab";
        System.out.println("Anagrams starting indices: " + solution.findAnagrams(s2, p2));
    }
}
