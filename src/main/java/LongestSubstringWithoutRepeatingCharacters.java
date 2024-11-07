import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;

        HashSet<Character> hashSet = new HashSet<>();

        while(end<s.length()){
            if(!hashSet.contains(s.charAt(end))){
                hashSet.add(s.charAt(end));
                end++;
                max = Math.max(hashSet.size(),max);
            }else {
                hashSet.remove(s.charAt(start));
                start++;
            }
        }
    return max; /* Time Complexity O(n) */
    }
}
