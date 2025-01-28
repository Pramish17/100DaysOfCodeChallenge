class PalindromicSubstring {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result + countPalindrome(s, i, i);
            result = result + countPalindrome(s, i, i + 1);
        }
        return result;
    }

    private int countPalindrome(String s, int l, int r) {
        int result = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            result++;
            l--;
            r++;
        }
        return result;
    }

    public static void main(String[] args) {
        PalindromicSubstring solution = new PalindromicSubstring();
        String s = "abc";
        System.out.println("Number of palindromic substrings: " + solution.countSubstrings(s));
    }
}
