import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();

        // Example 1
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Result: " + solution.evalRPN(tokens1)); // Output: 9

        // Example 2
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Result: " + solution.evalRPN(tokens2)); // Output: 6

        // Example 3
        String[] tokens3 = {"10", "6", "9", "3", "/", "-", "*", "17", "+", "5", "+"};
        System.out.println("Result: " + solution.evalRPN(tokens3)); // Output: 22
    }
}
