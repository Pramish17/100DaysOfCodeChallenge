public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        System.out.println(search(nums,target));
    }

    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid]<target) {
                left = left+1;
            } else if ((nums[mid]>target)) {
                right = right-1;
            }
        }

        return -1; /* Time Complexit O(log n) */
    }
}
