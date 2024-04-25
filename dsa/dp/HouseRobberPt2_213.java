package dp;

public class HouseRobberPt2_213 {
    // Leetcode 213
    // https://leetcode.com/problems/house-robber-ii/description/

    // In this question,
    // First and Last cannot be together as the array is circular.
    // Therefore, First and Last elements will be adjacent which we do not want.
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 }; // 4
        int ans = rob3(nums);
        System.out.println(ans);
    }

    // APPROACH 1 - R&M ***************************
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dpArr = new int[nums.length];
        int[] dpArr2 = new int[nums.length];

        for (int i = 0; i < dpArr.length; i++) {
            dpArr[i] = -1;
            dpArr2[i] = -1;
        }

        // Will exclude FIRST element
        int[] temp1 = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            temp1[i - 1] = nums[i];
        }

        // Will exclude LAST element
        int[] temp2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            temp2[i] = nums[i];
        }

        return Math.max(houseRobber(temp1.length - 1, dpArr, temp1), houseRobber(temp2.length - 1, dpArr2, temp2));
    }

    private static int houseRobber(int index, int[] dpArr, int[] nums) {
        if (index == 0) {
            return nums[0]; // ind = 0 means 0th element has not been picked yet.
        }

        if (index == -1) {
            return 0;
        }

        if (dpArr[index] != -1) {
            return dpArr[index];
        }

        // Pick one element and check with element at alternate position.
        int pick = nums[index] + houseRobber(index - 2, dpArr, nums);
        // Not picked element is 0 and the adjacent element will be checked with.
        int notPick = 0 + houseRobber(index - 1, dpArr, nums);

        dpArr[index] = Math.max(pick, notPick);

        return dpArr[index];
    }

    // APPROACH 3 - Space Optimization *************************
    public static int rob3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] temp1 = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            temp1[i - 1] = nums[i];
        }

        int[] temp2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            temp2[i] = nums[i];
        }

        return Math.max(helper(nums), helper(nums));
    }

    private static int helper(int[] nums) {
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
