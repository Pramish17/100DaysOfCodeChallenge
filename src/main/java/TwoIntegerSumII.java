public class TwoIntegerSumII {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        int target = 3;
        System.out.println(twoSum(numbers,target));
    }

    private static int[] twoSum(int[] numbers, int target) {
        int pointerA = 0;
        int pointerB = numbers.length-1;
        while(pointerA<pointerB){
            int sum = numbers[pointerA]+numbers[pointerB];
            if(sum<target){
                pointerA++;
            } else if (sum>target) {
                pointerB--;
            }else {
                return new int[]{pointerA+1,pointerB+1};  /* Time Complexity O(n) */
            }
        }
        return new int[0];
    }
}
