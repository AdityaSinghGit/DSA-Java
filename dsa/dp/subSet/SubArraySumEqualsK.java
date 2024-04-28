package dp.subSet;

import java.util.Arrays;

public class SubArraySumEqualsK {
    // https://www.naukri.com/code360/problems/subset-sum-equal-to-k_1550954?leftPanelTabValue=PROBLEM
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        int dp[][] = new int[n][k + 1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int answer = helper(arr, k, dp, n - 1);
        if (answer == 1)
            return true;
        else
            return false;
    }

    public static int helper(int[] arr, int target, int[][] dp, int index) {
        if (target == 0) {
            return 1;
        }

        if (index < 0) {
            return 0;
        }

        if (index == 0) {
            if (arr[0] == target) {
                return 1;
            }
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int nottake = helper(arr, target, dp, index - 1);
        int take = 0;
        if (arr[index] <= target) {
            take = helper(arr, target - arr[index], dp, index - 1);
        }

        if ((nottake == 1) || (take == 1)) {
            dp[index][target] = 1;
        } else
            dp[index][target] = 0;

        return dp[index][target];
    }
}
