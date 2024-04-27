package trees.BFS;

import java.util.LinkedList;
import java.util.Queue;

import trees.Nodes.TreeNode;

public class CousinsInBinaryTree993 {
    // Leetcode 993
    // https://leetcode.com/problems/cousins-in-binary-tree/description/
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // If current has x and y as children then false (same parent).
                if (currentNode.left != null && currentNode.right != null) {
                    if ((currentNode.left.val == x && currentNode.right.val == y)
                            || (currentNode.left.val == y && currentNode.right.val == x))
                        return false;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // If queue has those children, means they're cousins (same level)
            boolean cousin1 = false;
            boolean cousin2 = false;
            for (TreeNode node : queue) {
                if (node.val == (x < y ? x : y)) {
                    cousin1 = true;
                }
                if (node.val == (x > y ? x : y)) {
                    cousin2 = true;
                }
                if (cousin1 && cousin2) {
                    return true;
                }
            }
        }

        return false;
    }
}
