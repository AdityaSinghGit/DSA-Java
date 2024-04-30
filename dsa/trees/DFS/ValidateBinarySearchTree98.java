package trees.DFS;

import trees.Nodes.TreeNode;

public class ValidateBinarySearchTree98 {
    // Leetcode 98
    // https://leetcode.com/problems/validate-binary-search-tree/description/
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer low, Integer high) { // Integer instead of int bcz int can only be 0
                                                                       // but not null.
        if (node == null) {
            return true;
        }

        if (low != null && node.val <= low) {
            return false;
        }

        if (high != null && node.val >= high) {
            return false;
        }

        boolean left = helper(node.left, low, node.val);
        boolean right = helper(node.right, node.val, high);

        return left && right;
    }
}
