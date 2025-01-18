import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        List<Integer> result = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {
            dfs(root, 0);
            return result;
        }

        private void dfs(TreeNode node, int depth) {
            if (node == null) {
                return;
            }

            if (result.size() == depth) {
                result.add(node.val);
            }

            dfs(node.right, depth + 1);
            dfs(node.left, depth + 1);
        }
    }

    public static void main(String[] args) {
        // Create a binary tree for testing:
        //         1
        //        / \
        //       2   3
        //        \    \
        //         5    4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        Solution solution = new Solution();
        List<Integer> rightSide = solution.rightSideView(root);

        // Output the right side view of the binary tree
        System.out.println(rightSide);  // Expected output: [1, 3, 4]
    }
}
