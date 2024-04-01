package trees.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class DFS {
    int diameter = 0;

    // LeetCode 543
    // https://leetcode.com/problems/diameter-of-binary-tree/description/
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter - 1;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSide = height(node.left);
        int rightSide = height(node.right);

        int dia = leftSide + rightSide + 1;
        diameter = Math.max(leftSide, rightSide);

        return Math.max(leftSide, rightSide) + 1;

    }
    // -----------------X------------X----------X-------------------

    // LeetCode 226
    // https://leetcode.com/problems/invert-binary-tree/description/
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
    // -----------------X------------X----------X-------------------

    // LeetCode 104
    // https://leetcode.com/problems/maximum-depth-of-binary-tree/
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
    // -----------------X------------X----------X-------------------

    // LeetCode 114
    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
    // -----------------X------------X----------X-------------------

    // LeetCode 98
    // https://leetcode.com/problems/validate-binary-search-tree/description/
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true;
        }

        if (high != null && node.val >= high) {
            return false;
        }

        if (low != null && node.val <= low) {
            return false;
        }

        boolean left = helper(node.left, low, node.val);
        boolean right = helper(node.right, node.val, high);

        return left && right;
    }
    // -----------------X------------X----------X-------------------

    // LeetCode 230
    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    int counter = 0;

    public int kthSmallest(TreeNode root, int k) {
        TreeNode result = helper(root, k);
        return result.val;
    }

    private TreeNode helper(TreeNode node, int k) {
        if (node == null) {
            return null;
        }

        TreeNode left = helper(node.left, k);

        if (left != null) {
            return left;
        }

        counter++;

        if (counter == k) {
            return node;
        }

        return helper(node.right, k);
    }
    // -----------------X------------X----------X-------------------
}
