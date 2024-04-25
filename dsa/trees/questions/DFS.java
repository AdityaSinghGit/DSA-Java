package trees.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

    // LeetCode 236
    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
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

    // LeetCode 105
    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < preorder.length - 1; i++) {
            if (inorder[i] == root.val) {
                index = i;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));

        return root;
    }
    // -----------------X------------X----------X-------------------

    // DFS using Stack
    void dfsStack(Node node) {
        if (node == null) {
            return;
        }

        List<Integer> result = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.val);

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

    }

    // -----------------X------------X----------X-------------------
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.val = value;
        }
    }

    private class Node {
        int val;
        Node left;
        Node right;
        @SuppressWarnings("unused")
        Node next;

        @SuppressWarnings("unused")
        Node(int val) {
            this.val = val;
        }
    }
}
