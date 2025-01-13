public class SubTreeOfAnotherTree {

    public static void main(String[] args) {
        // Creating the main tree (root)
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // Creating the subtree (subRoot)
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        // Checking if subRoot is a subtree of root
        Solution solution = new Solution();
        boolean result = solution.isSubtree(root, subRoot);

        // Output the result
        System.out.println("Is subRoot a subtree of root? " + result);
    }

    // TreeNode definition
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

    // Solution class containing the logic for checking the subtree
    static class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            String fullTree = preOrderTraversal(root);
            String subTree = preOrderTraversal(subRoot);
            return fullTree.contains(subTree);
        }

        private String preOrderTraversal(TreeNode node) {
            if (node == null) return "null";

            StringBuilder sb = new StringBuilder(",");
            sb.append(node.val);
            sb.append(preOrderTraversal(node.left));
            sb.append(preOrderTraversal(node.right));

            return sb.toString();
        }
    }
}
