public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        // Calculate the total sum of the array
        for (int num : nums) {
            sum += num;
        }

        // If the sum is odd, it's impossible to split into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        // Target sum for one subset
        sum /= 2;

        // Initialize a DP array to track achievable subset sums
        boolean[] result = new boolean[sum + 1];
        result[0] = true; // Base case: sum of 0 is always achievable

        // Process each number in the array
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                result[j] = result[j] || result[j - num];
            }
        }

        // The answer is whether the target sum is achievable
        return result[sum];
    }

    // Main method for testing
    public static void main(String[] args) {
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();

        // Test case 1
        int[] nums1 = {1, 5, 11, 5};
        System.out.println("Test case 1: " + solution.canPartition(nums1)); // Expected: true

        // Test case 2
        int[] nums2 = {1, 2, 3, 5};
        System.out.println("Test case 2: " + solution.canPartition(nums2)); // Expected: false
    }
}
