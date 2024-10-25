import java.util.Stack;

public class MinimumNoOfSwapsToMakeTheStringBalanced {
    public static void main(String[] args) {
        String s = "]]][[[";
        System.out.println(minSwaps(s));
    }

    private static int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push('[');
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    count++;
                }
            }
        }
        int minimumSwap = (count + 1) / 2;
        return minimumSwap; /* TimeComplexity O(n) */
    }
}
