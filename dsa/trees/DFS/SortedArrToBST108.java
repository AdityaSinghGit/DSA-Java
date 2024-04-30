package trees.DFS;

import trees.Nodes.TreeNode;

public class SortedArrToBST108 {
    // Leetcode 108
    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

    // TIME : O(n)
    // SPACE : O(n)
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);

        return root;
    }
}
