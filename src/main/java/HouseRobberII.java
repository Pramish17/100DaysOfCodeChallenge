public class HouseRobberII {
    public static int rob(int[] nums) {
        // Edge case: If there's only one house, return its value
        if (nums.length == 1) {
            return nums[0];
        }

        // Helper function to solve the linear House Robber problem
        return Math.max(robLinear(nums, 0, nums.length - 2), robLinear(nums, 1, nums.length - 1));
    }

    private static int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // Tracks rob amount two houses back
        int prev1 = 0; // Tracks rob amount one house back

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1; // Move prev2 to prev1
            prev1 = current; // Update prev1 to current
        }

        return prev1; // The maximum amount robbed
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {3, 4, 3};
        System.out.println("Max Robbed Amount (Example 1): " + rob(nums1)); // Output: 4

        // Example 2
        int[] nums2 = {2, 9, 8, 3, 6};
        System.out.println("Max Robbed Amount (Example 2): " + rob(nums2)); // Output: 15
    }
}
