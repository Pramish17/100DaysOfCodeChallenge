public class CountGoodNodesInBinaryTree {

    public static void main(String[] args) {
        // Example of creating a binary tree and testing the goodNodes function
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        Solution solution = new Solution();
        int result = solution.goodNodes(root);
        System.out.println("Good Nodes Count: " + result);
    }

    static class TreeNode {
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

        public int goodNodes(TreeNode root) {
            return dfs(root, root.val);
        }

        private int dfs(TreeNode node, int maxVal) {
            if (node == null) {
                return 0;
            }

            int result = (node.val >= maxVal) ? 1 : 0;
            maxVal = Math.max(maxVal, node.val);
            result = result + dfs(node.left, maxVal);
            result = result + dfs(node.right, maxVal);
            return result;
        }
    }
}
