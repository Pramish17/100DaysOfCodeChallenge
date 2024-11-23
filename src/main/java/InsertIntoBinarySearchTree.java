public class InsertIntoBinarySearchTree {

    // Definition for a binary tree node.
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

    // Method to insert a value into the BST
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode currentNode = root;
        while (true) {
            if (currentNode.val <= val) {
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = new TreeNode(val);
                    break;
                }
            } else {
                if (currentNode.left != null) {
                    currentNode = currentNode.left;
                } else {
                    currentNode.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        InsertIntoBinarySearchTree tree = new InsertIntoBinarySearchTree();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int val = 5;

        TreeNode updatedRoot = tree.insertIntoBST(root, val);
        System.out.println("Value inserted: " + val);
    }
}
