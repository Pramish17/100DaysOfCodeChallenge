public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
    }

    private static int findLengthOfLCIS(int[] nums) {
        int result = 0;
        int checkpoint = 0;
        for(int i=0; i<nums.length; i++){
            if (i > 0 && nums[i] <= nums[i - 1]) {
                checkpoint = i;
            }
            result= Math.max(result, i-checkpoint+1);
        }
        return  result; /* Time Complexity O(n) */
    }
}
