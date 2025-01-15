public class SingleNumber {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};  // Example 1
        int[] nums2 = {7, 6, 6, 7, 8};  // Example 2

        System.out.println("Output for nums1: " + findSingleNumber(nums1));  // Should print 2
        System.out.println("Output for nums2: " + findSingleNumber(nums2));  // Should print 8
    }

    public static int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;  // Apply XOR operation
        }
        return result;
    }
}
