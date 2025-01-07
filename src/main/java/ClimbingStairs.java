import java.util.HashMap;

public class ClimbingStairs {
    // Memoization map to store results of subproblems
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        // Check if the result is already computed
        if (map.containsKey(n)) {
            return map.get(n);
        }

        // Compute the result and store it in the map
        int val = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, val);
        return val;
    }

    // Main method to run test cases
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();

        // Test cases
        System.out.println("climbStairs(1) = " + solution.climbStairs(1)); // Output: 1
        System.out.println("climbStairs(2) = " + solution.climbStairs(2)); // Output: 2
        System.out.println("climbStairs(3) = " + solution.climbStairs(3)); // Output: 3
        System.out.println("climbStairs(4) = " + solution.climbStairs(4)); // Output: 5
        System.out.println("climbStairs(5) = " + solution.climbStairs(5)); // Output: 8
        System.out.println("climbStairs(10) = " + solution.climbStairs(10)); // Output: 89
    }
}
