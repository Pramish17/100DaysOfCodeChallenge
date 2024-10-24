import java.util.*;

public class GroupAnagrams {
    public static void main(String args[]) {
        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sortString = new String(charArr);
            if (!map.containsKey(sortString)) {
                map.put(sortString, new ArrayList<>());
            }
            map.get(sortString).add(s);

        }
        result = new ArrayList<>(map.values());
        return result;  /* Time Complexity O(n*klogk)*/
    }
}
