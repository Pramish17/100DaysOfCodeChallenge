import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> newMap = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                newMap.put(total + num,
                        newMap.getOrDefault(total + num, 0) + count);
                newMap.put(total - num,
                        newMap.getOrDefault(total - num, 0) + count);
            }
            map = newMap;
        }
        return map.getOrDefault(target, 0);
    }

    public static void main(String[] args) {
        // Example usage
        TargetSum targetSum = new TargetSum();
        int[] nums = {1, 1, 1, 1};
        int target = 2;
        int result = targetSum.findTargetSumWays(nums, target);
        System.out.println("Number of ways to reach the target: " + result);  // Output should be 4
    }
}
