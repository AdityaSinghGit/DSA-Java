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
            Node current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
    // -----------------X------------X----------X-------------------

    // LeetCode 199
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }
    // -----------------X------------X----------X-------------------

    // LeetCode 993
    // https://leetcode.com/problems/cousins-in-binary-tree/description/
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy));
    }

    private TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }

        if (node.val == x) {
            return node;
        }

        TreeNode n = findNode(node.left, x);
        if (n != null) {
            return n;
        }
        return findNode(node.right, x);
    }

    private int level(TreeNode node, TreeNode x, int level) {
        if (node == null) {
            return 0;
        }

        if (node == x) {
            return level;
        }

        int n = level(node.left, x, level + 1);
        if (n != null) {
            return n;
        }

        return level(node.right, x, level + 1);
    }

    private boolean isSibling(TreeNode node, TreeNode xx, TreeNode yy) {
        if (node == null) {
            return false;
        }

        return (node.left == xx && node.right == yy) || (node.left == yy && node.right == xx)
                || isSibling(node.left, xx, yy)
                || isSibling(node.right, xx, yy);
    }
    // -----------------X------------X----------X-------------------

    // LeetCode 101
    // https://leetcode.com/problems/symmetric-tree/description/
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

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
        return queue.isEmpty();
    }
    // -----------------X------------X----------X-------------------

}
