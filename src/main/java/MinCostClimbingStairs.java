public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        // Iterate through the array in reverse, starting from the third-to-last element
        for (int i = cost.length - 3; i >= 0; i--) {
            // Update each step with the minimum cost of reaching the top from that step
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        // Return the minimum cost to start from either of the first two steps
        return Math.min(cost[0], cost[1]);
    }

    // Main method for testing the function
    public static void main(String[] args) {
        MinCostClimbingStairs solution = new MinCostClimbingStairs();

        // Test case
        int[] cost = {10, 15, 20};
        int result = solution.minCostClimbingStairs(cost);

        // Output the result
        System.out.println("Minimum cost to climb the stairs: " + result);

        // Another test case
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int result2 = solution.minCostClimbingStairs(cost2);
        System.out.println("Minimum cost to climb the stairs: " + result2);
    }
}
