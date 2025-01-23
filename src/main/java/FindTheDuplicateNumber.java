public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int left = 1;  // The smallest possible value in the array
        int right = nums.length - 1;  // The largest possible value in the array

        // Perform binary search on the range [1, n-1]
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;

            // Count how many numbers are less than or equal to mid
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            // If count > mid, the duplicate must be in the left half
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left; // The duplicate number will be the left pointer
    }

    public static void main(String[] args) {
        // Example usage
        FindTheDuplicateNumber finder = new FindTheDuplicateNumber();

        // Example array with a duplicate
        int[] nums = {1, 3, 4, 2, 2};

        // Find and print the duplicate number
        int duplicate = finder.findDuplicate(nums);
        System.out.println("Duplicate number: " + duplicate);
    }
}
