package trees.DFS;

import trees.Nodes.TreeNode;

public class FlattenBTtoLinkedList114 {
    // Leetcode 114
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
}
