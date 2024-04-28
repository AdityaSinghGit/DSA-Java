package trees.DFS;

import trees.Nodes.TreeNode;

public class InvertABinaryTree226 {
    // Leetcode 226
    // https://leetcode.com/problems/invert-binary-tree/

    // TIME : O(n)
    // SPACE : O(n)
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
