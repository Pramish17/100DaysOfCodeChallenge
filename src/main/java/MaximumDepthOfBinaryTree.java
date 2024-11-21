import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    // Definition for a binary tree node
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

    // Method to calculate the maximum depth using recursion
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: if the tree is empty, depth is 0
        }

        int left = maxDepth(root.left); // Recursively find depth of the left subtree
        int right = maxDepth(root.right); // Recursively find depth of the right subtree

        return Math.max(left, right) + 1; // Return the max depth + 1 (current node)
    }


    // Example usage
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();

        // Creating a sample tree: [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Finding the maximum depth
        int depth = solution.maxDepth(root);
        System.out.println("Maximum Depth of the Binary Tree: " + depth);
    }
}

//using DFS
// Queue<TreeNode> queue = new LinkedList<>();
// queue.offer(root);
// int level = 0;

// while (!queue.isEmpty()) {
//     int size = queue.size();
//     for (int i = 0; i < size; i++) {
//         TreeNode node = queue.poll();
//         if (node.left != null) {
//             queue.offer(node.left);
//         }
//         if (node.right != null) {
//             queue.offer(node.right);
//         }
//     }
//     level++;
// }

// return level;
