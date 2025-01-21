import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            dfs(root, 0);
            return result;
        }

        private void dfs(TreeNode node, int depth) {
            if (node == null) {
                return;
            }

            if (result.size() == depth) {
                result.add(new ArrayList<>());
            }

            result.get(depth).add(node.val);
            dfs(node.left, depth + 1);
            dfs(node.right, depth + 1);
        }
    }

    public static void main(String[] args) {
        // Create a sample binary tree:
        //        3
        //       / \
        //      9  20
        //         /  \
        //        15   7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);

        // Print the result
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
