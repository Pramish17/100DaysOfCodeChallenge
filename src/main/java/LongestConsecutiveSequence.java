import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        // Step 1: Add all elements to the HashSet
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        // Step 2: Find the longest sequence
        for (int num : nums) {
            // Check if this is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count consecutive elements
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update maximum length
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test Example 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Output: " + longestConsecutive(nums1)); // Output: 4

        // Test Example 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Output: " + longestConsecutive(nums2)); // Output: 9
    }
}
