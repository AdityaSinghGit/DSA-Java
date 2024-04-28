package trees.DFS;

import trees.Nodes.TreeNode;

public class DiameterOfBinaryTree543 {
    // Leetcode 543
    // https://leetcode.com/problems/diameter-of-binary-tree/

    // TIME : O(n)
    // SPACE : O(n) if binary tree is skewed

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }

}
