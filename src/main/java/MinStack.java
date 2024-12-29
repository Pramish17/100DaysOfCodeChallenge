import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack; // Stack to store all elements
    private Stack<Integer> minStack;  // Stack to track the minimum element

    // Constructor
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push operation
    public void push(int val) {
        // Push the value onto the minStack if it is the smallest so far
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        // Push onto the main stack
        mainStack.push(val);
    }

    // Pop operation
    public void pop() {
        // Remove from minStack if the top of minStack matches the top of mainStack
        if (minStack.peek().equals(mainStack.peek())) {
            minStack.pop();
        }
        mainStack.pop();
    }

    // Top operation
    public int top() {
        return mainStack.peek();
    }

    // GetMin operation
    public int getMin() {
        return minStack.peek();
    }

    // Main method for testing
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(3);
        obj.push(7);
        System.out.println("Top: " + obj.top());      // Output: 7
        System.out.println("Minimum: " + obj.getMin()); // Output: 3
        obj.pop();
        System.out.println("Minimum: " + obj.getMin()); // Output: 3
        obj.pop();
        System.out.println("Minimum: " + obj.getMin()); // Output: 5
    }
}
