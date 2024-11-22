public class BalancedBinaryTree {

    // Definition for a binary tree node
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

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(tree.isBalanced(root)); // Output: false
    }
}
