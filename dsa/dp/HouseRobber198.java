package dp;

public class HouseRobber198 {
    // Leetcode 198
    // https://leetcode.com/problems/house-robber/
    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 }; // 12
        int ans = rob3(nums);
        System.out.println(ans);
    }

    // APPROACH 1 : R&M
    public static int rob(int[] nums) {
        int[] dpArr = new int[nums.length];

        for (int i = 0; i < dpArr.length; i++) {
            dpArr[i] = -1;
        }

        return houseRobber(nums.length - 1, dpArr, nums);
    }

    private static int houseRobber(int index, int[] dpArr, int[] nums) {
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

    // APPROACH 3 - Space Optimization
    public static int rob3(int[] nums) {
        int prev1 = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int take = nums[i];
            if (i > 1)
                take += prev2;

            int notTake = 0 + prev1;
            int curr = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
