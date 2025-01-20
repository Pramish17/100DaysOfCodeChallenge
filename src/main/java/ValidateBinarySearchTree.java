public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        // Example of creating a binary tree and testing the isValidBST function
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Solution solution = new Solution();
        boolean result = solution.isValidBST(root);
        System.out.println("Is the tree a valid BST? " + result);
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
        public boolean isValidBST(TreeNode root) {
            return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean isValid(TreeNode node, long left, long right) {
            if (node == null) {
                return true;
            }
            if (!(left < node.val && node.val < right)) {
                return false;
            }
            return isValid(node.left, left, node.val) &&
                    isValid(node.right, node.val, right);
        }
    }
}
