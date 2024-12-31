import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        int n = 3; // Example input
        List<String> result = gp.generateParenthesis(n);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String str, int open, int close, int n) {
        if (str.length() == n * 2) {
            res.add(str);
            return;
        }
        if (open < n) {
            backtrack(res, str + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(res, str + ")", open, close + 1, n);
        }
    }
}
