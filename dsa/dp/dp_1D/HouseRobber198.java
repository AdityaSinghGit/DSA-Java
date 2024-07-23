package dp.dp_1D;

public class HouseRobber198 {
    // Leetcode 198
    // https://leetcode.com/problems/house-robber/
    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 }; // 12
        int ans = rob2(nums);
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

        return dpArr[index] = Math.max(pick, notPick);
    }

    // APPROACH 2 : TABULATION
    public static int rob1(int[] nums) {
        int n = nums.length;
        int[] dpArr = new int[n];

        for (int i = 0; i < dpArr.length; i++) {
            dpArr[i] = -1;
        }

        dpArr[0] = nums[0];
        int neg = 0; // consider for -ve index or 2nd base case

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick += dpArr[i - 2];
            }
            int notPick = 0 + dpArr[i - 1];

            dpArr[i] = Math.max(pick, notPick);
        }

        return dpArr[n - 1];
    }

    // APPROACH 3 - Space Optimization
    public static int rob2(int[] nums) {
        int n = nums.length;

        int prev = nums[0];
        int prev2 = 0; // consider for -ve index or 2nd base case

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick += prev2;
            }
            int notPick = 0 + prev;

            int curri = Math.max(pick, notPick);
            prev2 = prev;
            prev = curri;
        }

        return prev;
    }
}
