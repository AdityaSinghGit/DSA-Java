package trees.DFS;

import trees.Nodes.TreeNode;

public class MaximumDepthOfBinaryTree104 {
    // Leetcode 104
    // https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
