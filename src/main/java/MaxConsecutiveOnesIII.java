public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums= {1,1,1,0,0,0,1,1,1,1,0};
        int k =2;
        System.out.println(longestOnes(nums,k));
    }

    private static int longestOnes(int[] nums, int k) {
        int left = 0;
        int max = 0;
        int zerosCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zerosCount++;
            }

            while (zerosCount > k) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        return max; /* Time Complexity O(n)*/
    }
}
