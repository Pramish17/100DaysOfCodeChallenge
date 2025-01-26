import java.util.*;

public class KthSmallestElementInBST {
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

    public static class Solution {
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            dfs(root, list);
            return list.get(k - 1);
        }

        private void dfs(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }
            dfs(node.left, list);
            list.add(node.val);
            dfs(node.right, list);
        }
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        Solution solution = new Solution();
        int k = 1;
        int result = solution.kthSmallest(root, k);

        System.out.println("The " + k + "th smallest element is: " + result);
    }
}
