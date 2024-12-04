import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> current, List<String> result) {
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;

            String segment = s.substring(start, start + len);

            if (isValid(segment)) {
                current.add(segment);
                backtrack(s, start + len, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }

    public static void main(String[] args) {
        String s1 = "25525511135";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + restoreIpAddresses(s1));

        String s2 = "0000";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + restoreIpAddresses(s2));

        String s3 = "101023";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + restoreIpAddresses(s3));
    }
}
