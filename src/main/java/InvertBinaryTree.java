public class InvertBinaryTree {

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

    // Method to invert a binary tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

        // Swapping the left and right children
        root.left = rightNode;
        root.right = leftNode;

        return root; /* Time Complexity O(n)*/
    }

    // Main method for testing
    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();

        // Creating a simple binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Printing before inverting
        System.out.println("Before inverting:");
        invertBinaryTree.inOrderTraversal(root);

        // Invert the binary tree
        invertBinaryTree.invertTree(root);

        // Printing after inverting
        System.out.println("\nAfter inverting:");
        invertBinaryTree.inOrderTraversal(root);
    }

    // Helper method for in-order traversal
    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.val + " ");
        inOrderTraversal(node.right);
    }
}
