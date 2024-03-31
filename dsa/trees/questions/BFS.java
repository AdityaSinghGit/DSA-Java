package trees.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

import trees.CustomBinaryTree;

public class BFS {

    // LeetCode 102
    // https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
    // -----------------X------------X----------X-------------------

    // LeetCode 637
    // https://leetcode.com/problems/average-of-levels-in-binary-tree/
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Double counter = 0.0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                counter += currentNode.val;
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(counter / levelSize);
        }
        return result;
    }
    // -----------------X------------X----------X-------------------

    // Return next node value(or successor) for a given node value by level (BFS)
    public TreeNode findSuccessor(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int ans = 0;
            TreeNode currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.value == val) {
                break;
            }
        }
        return queue.peek();
    }
    // -----------------X------------X----------X-------------------

    // LeetCode 103
    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        boolean changeRoute = false;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            List<Integer> newList = new ArrayList<>();
            if (changeRoute) {
                for (int i = currentLevel.size() - 1; i >= 0; i--) {
                    newList.add(currentLevel.get(i));
                }
            }
            result.add(changeRoute ? newList : currentLevel);
            changeRoute = !changeRoute;
        }
        return result;
    }
    // -----------------X------------X----------X-------------------

    // LeetCode 107
    // https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        List<List<Integer>> newResult = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            newResult.add(result.get(i));
        }
        return newResult;
    }
    // -----------------X------------X----------X-------------------

    // LeetCode 116
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMost = root;

        while (leftMost.left != null) {

        }

        return root;
    }
    // -----------------X------------X----------X-------------------
}
