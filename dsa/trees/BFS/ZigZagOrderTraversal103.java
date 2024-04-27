package trees.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import trees.Nodes.TreeNode;

public class ZigZagOrderTraversal103 {
    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>(levelSize);
            zigzag = !zigzag;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                list.add(currentNode.val);
                if (zigzag) {
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                } else {
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                }
            }
            list.clear();
            result.add(list);
        }
        return result;

    }

}
