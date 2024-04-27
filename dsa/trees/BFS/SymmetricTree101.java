package trees.BFS;

import java.util.LinkedList;
import java.util.Queue;

import trees.Nodes.TreeNode;

public class SymmetricTree101 {
    // Leetcode 101
    // https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }

}
