import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current number is greater than 0, break the loop (no valid triplets possible)
            if (nums[i] > 0) break;

            // Skip duplicate numbers to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Two-pointer approach
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) {
                    r--; // Decrease the right pointer
                } else if (sum < 0) {
                    l++; // Increase the left pointer
                } else {
                    // Add the triplet to the result list
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // Skip duplicates for the left pointer
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum.threeSum(nums);
        System.out.println(result);
    }
}
