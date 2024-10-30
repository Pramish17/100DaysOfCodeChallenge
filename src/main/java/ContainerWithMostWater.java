public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {

        int maxArea = 0;
        int pointerA = 0;
        int pointerB = height.length-1;

        while(pointerA<pointerB){
            if(height[pointerA] < height[pointerB]){
                maxArea = Math.max(maxArea, height[pointerA]*(pointerB-pointerA));
                pointerA++;
            }else {
                maxArea = Math.max(maxArea, height[pointerB]*(pointerB-pointerA));
                pointerB--;
            }
        }
        return maxArea; /* Time Complexity O(n) */
    }
}
