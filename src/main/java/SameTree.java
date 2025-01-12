public class SameTree {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Check if both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // Check if both nodes are not null and values are equal
        if (p != null && q != null && p.val == q.val) {
            // Recursively check left and right subtrees
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        SameTree solution = new SameTree();

        // Test case 1
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        System.out.println("Test Case 1: " + solution.isSameTree(tree1, tree2)); // Expected output: true

        // Test case 2
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);

        TreeNode tree4 = new TreeNode(1);
        tree4.right = new TreeNode(2);

        System.out.println("Test Case 2: " + solution.isSameTree(tree3, tree4)); // Expected output: false
    }
}
