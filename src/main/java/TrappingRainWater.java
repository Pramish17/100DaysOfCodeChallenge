public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int lMax = 0;
        int rMax = 0;
        int res = 0;

        while (l < r) {
            if (height[l] > lMax) {
                lMax = Math.max(height[l], lMax);
            }
            if (height[r] > rMax) {
                rMax = Math.max(height[r], rMax);
            }
            if (lMax < rMax) {
                res = res + lMax - height[l];
                l++;
            } else {
                res = res + rMax - height[r];
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();

        // Example usage
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = solution.trap(height);

        System.out.println("Trapped water: " + result);
    }
}
