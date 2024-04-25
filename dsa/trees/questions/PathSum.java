package trees.questions;

public class PathSum {

    // LeetCode 112
    // https://leetcode.com/problems/path-sum/
    int count = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        count += root.val;

        if (count == targetSum && (root.left == null && root.right == null)) {
            return true;
        }

        boolean left = hasPathSum(root.left, targetSum);
        boolean right = hasPathSum(root.right, targetSum);

        count -= root.val;

        return left || right;
    }
    // -----------------X------------X----------X-------------------

    // LeetCode 129
    // https://leetcode.com/problems/sum-root-to-leaf-numbers/
    int sum = 0;
    int tempSum = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int tempSum) {
        if (root == null) {
            return;
        }

        tempSum = tempSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum += tempSum;
            return;
        }

        helper(root.left, tempSum);

        helper(root.right, tempSum);

        tempSum -= root.val;
    }

    // -----------------X------------X----------X-------------------
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        @SuppressWarnings("unused")
        TreeNode(int value) {
            this.val = value;
        }
    }
}
