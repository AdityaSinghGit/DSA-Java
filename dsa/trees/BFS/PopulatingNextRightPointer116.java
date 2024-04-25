package trees.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointer116 {
    // LeetCode 116
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

    // SOLUTION WITH QUEUE
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (i + 1 < levelSize) {
                    currentNode.next = queue.peek();
                } else {
                    currentNode.next = null;
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return root;
    }

    // SOLUTION WITHOUT QUEUE
    public Node connect2(Node root) {
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

    private class Node {
        @SuppressWarnings("unused")
        int value;
        Node left;
        Node right;
        Node next;

        @SuppressWarnings("unused")
        Node(int value) {
            this.value = value;
        }
    }
}
