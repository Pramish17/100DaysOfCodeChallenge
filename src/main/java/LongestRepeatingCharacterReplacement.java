import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    /**
     * Find the length of the longest substring where at most k replacements
     * make all characters in the substring the same.
     *
     * @param s the input string
     * @param k the maximum number of replacements
     * @return the length of the longest valid substring
     */
    public int characterReplacement(String s, int k) {
        // HashMap to count character frequencies
        HashMap<Character, Integer> count = new HashMap<>();

        int l = 0; // Left pointer
        int maxF = 0; // Maximum frequency of a single character in the current window
        int res = 0; // Result to store the maximum length of the valid substring

        for (int r = 0; r < s.length(); r++) {
            // Add the character at position r to the frequency map
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, count.get(s.charAt(r)));

            // If the current window is invalid, shrink it from the left
            while ((r - l + 1) - maxF > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            // Update the result with the maximum length of the valid window
            res = Math.max(res, r - l + 1);
        }

        return res; // Return the maximum length
    }

    // Main method to test the function
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();

        // Test cases
        String s = "AABABBA";
        int k = 1;
        System.out.println("Longest repeating character replacement: " + solution.characterReplacement(s, k));
    }
}
