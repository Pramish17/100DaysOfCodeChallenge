import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        recur(candidates, target, 0, cur, res);
        return res;
    }

    private void recur(int[] candidates, int target, int ind, ArrayList<Integer> cur, List<List<Integer>> res) {
        if (ind == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(cur)); // Add a new list to avoid mutation
            }
            return;
        }
        // Include the current candidate if it doesn't exceed the target
        if (candidates[ind] <= target) {
            cur.add(candidates[ind]); // Add the candidate to the current combination
            recur(candidates, target - candidates[ind], ind, cur, res); // Recur with reduced target
            cur.remove(cur.size() - 1); // Backtrack
        }
        // Exclude the current candidate and move to the next
        recur(candidates, target, ind + 1, cur, res);
    }

    // Main method for testing the functionality
    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = solution.combinationSum(candidates, target);
        System.out.println("Combinations summing up to " + target + ":");
        System.out.println(result);
    }
}
