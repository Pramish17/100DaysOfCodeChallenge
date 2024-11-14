import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        // Creating the tree: [1, 2, 3, 4]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        int x = 4;
        int y = 3;
        System.out.println(isCousins(root, x, y));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)) {
                        return false;
                    }
                }

                // Check if we found either x or y at the current level
                if (node.left != null) {
                    if (node.left.val == x) foundX = true;
                    if (node.left.val == y) foundY = true;
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    if (node.right.val == x) foundX = true;
                    if (node.right.val == y) foundY = true;
                    queue.offer(node.right);
                }
            }

            // If both x and y are found at the same level, they are cousins
            if (foundX && foundY) return true;

            // If only one is found at the current level, they are not cousins
            if (foundX || foundY) return false;
        }

        return false;  /* Time Complexiy O(n) */
    }
}
