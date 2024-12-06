public class VerifyingAnAlienDictionary {
    public int[] charMap;

    public boolean isAlienSorted(String[] words, String order) {
        charMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charMap[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public int compare(String word1, String word2) {
        int i = 0;
        int j = 0;
        int compareValue = 0;

        while (i < word1.length() && j < word2.length() && compareValue == 0) {
            compareValue = charMap[word1.charAt(i) - 'a'] - charMap[word2.charAt(i) - 'a'];
            i++;
            j++;
        }
        if (compareValue == 0) {
            return word1.length() - word2.length();
        } else {
            return compareValue;
        }
    }

    public static void main(String[] args) {
        VerifyingAnAlienDictionary solution = new VerifyingAnAlienDictionary();

        // Test Case 1
        String[] words1 = {"hello", "leetcode"};
        String order1 = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(solution.isAlienSorted(words1, order1)); // Output: true

        // Test Case 2
        String[] words2 = {"word", "world", "row"};
        String order2 = "worldabcefghijkmnpqstuvxyz";
        System.out.println(solution.isAlienSorted(words2, order2)); // Output: false

        // Test Case 3
        String[] words3 = {"apple", "app"};
        String order3 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(solution.isAlienSorted(words3, order3)); // Output: false
    }
}
