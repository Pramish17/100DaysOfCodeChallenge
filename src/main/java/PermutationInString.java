import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (m < n) return false;

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        // Initialize the frequency maps for s1 and the first n characters of s2
        for (int i = 0; i < n; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        // Sliding window to check permutations in the rest of s2
        for (int i = n; i < m; i++) {
            if (Arrays.equals(map1, map2)) {
                return true;
            }
            // Update the sliding window
            map2[s2.charAt(i - n) - 'a']--;
            map2[s2.charAt(i) - 'a']++;
        }

        // Final check for the last window
        return Arrays.equals(map1, map2);
    }

    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();
        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean result = solution.checkInclusion(s1, s2);
        System.out.println("Does s2 contain a permutation of s1? " + result);
    }
}
