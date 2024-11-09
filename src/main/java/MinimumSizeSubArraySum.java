public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target,nums));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            while(sum>=target){
                result = Math.min(result, i+1 - left);
                sum -= nums[left];
                left++;
            }
        }

        return (result != Integer.MAX_VALUE)? result:0; /* Time Complexity O(n)*/
    }
}
