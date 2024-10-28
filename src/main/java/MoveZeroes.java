public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {  /* Time Complexity O(n) */
        if(nums.length<2){
            return;
        }
        int aPointer = 0;
        int bPointer = 1;
        while(bPointer<nums.length){
            if(nums[aPointer] !=0 ){
                aPointer++;
                bPointer++;
            }else if(nums[bPointer] == 0){
                bPointer++;
            }else{
                int temp = nums[bPointer];
                nums[bPointer]=nums[aPointer];
                nums[aPointer] = temp;
            }
        }
    }
}
