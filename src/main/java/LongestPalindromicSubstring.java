public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s; // A single character is always a palindrome.
        }

        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check all substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check all substrings of length 3 or more
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1; // Ending index of substring
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = length;
                }
            }
        }

        // Return the longest palindromic substring
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String input1 = "ababad";
        String input2 = "abbc";
        System.out.println("Input: " + input1 + " -> Output: " + solution.longestPalindrome(input1));
        System.out.println("Input: " + input2 + " -> Output: " + solution.longestPalindrome(input2));
    }
}
