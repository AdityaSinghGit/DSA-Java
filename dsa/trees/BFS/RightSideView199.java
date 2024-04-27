package trees.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import trees.Nodes.TreeNode;

public class RightSideView199 {
    // Leetcode 199
    // https://leetcode.com/problems/binary-tree-right-side-view/description/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int leveltSize = queue.size();
            List<Integer> list = new ArrayList<>(leveltSize);
            for (int i = 0; i < leveltSize; i++) {
                TreeNode currentNode = queue.poll();

                list.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(list.get(list.size() - 1));
        }
        return result;
    }
}
