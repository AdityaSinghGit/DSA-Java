package dp;

public class HouseRobber198 {
    // Leetcode 198
    // https://leetcode.com/problems/house-robber/
    public static void main(String[] args) {

    }

    // APPROACH 1 : R&M
    public int rob(int[] nums) {
        int[] dpArr = new int[nums.length];

        for (int i = 0; i < dpArr.length; i++) {
            dpArr[i] = -1;
        }

        return houseRobber(nums.length - 1, dpArr, nums);
    }

    private int houseRobber(int index, int[] dpArr, int[] nums) {
        if (index == 0) {
            return nums[0];
        }

        if (index == -1) {
            return 0;
        }

        if (dpArr[index] != -1) {
            return dpArr[index];
        }

        int pick = nums[index] + houseRobber(index - 2, dpArr, nums);
        int notPick = 0 + houseRobber(index - 1, dpArr, nums);

        dpArr[index] = Math.max(pick, notPick);

        return dpArr[index];
    }
}
