public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sumOfNaturalNo = n*(n+1)/2;
        int sum=0;
        for(int num: nums){
            sum = sum+num;
        }
        sum = sumOfNaturalNo-sum;
        return sum;
       /* Time Complexity O(n)
          Space Complexity O(1)*/
    }
    public static void main (String[] args){
        int[] nums = {1,2,3};
        System.out.println(missingNumber(nums));
    }
}
