import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(nums, 0, new ArrayList<>());
        return result;
    }

    public void findSubsets(int[] nums, int index, List<Integer> sublist) {
        if (index == nums.length) {
            result.add(new ArrayList<>(sublist));
            return;
        }

        // Include the current number in the subset
        sublist.add(nums[index]);
        findSubsets(nums, index + 1, sublist);

        // Exclude the current number from the subset
        sublist.remove(sublist.size() - 1);
        findSubsets(nums, index + 1, sublist);
    }

    public static void main(String[] args) {
        Subsets solution = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
