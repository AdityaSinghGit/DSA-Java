package dp.subSet;

import java.util.Arrays;

public class SubSetSumEqualsK {
    // https://www.naukri.com/code360/problems/subset-sum-equal-to-k_1550954?leftPanelTabValue=PROBLEM

    // TC: O(2^N)
    // SC: O(N)

    // R & M
    // TC: O(N x K)
    // SC: O(N x K) + O(N) (RSS)
    public static boolean subsetSumToK(int n, int k, int arr[]) {
        Boolean dp[][] = new Boolean[n][k + 1];

        for (Boolean[] row : dp) {
            Arrays.fill(row, null);
        }

        return helper(arr, k, dp, n - 1);
    }

    public static boolean helper(int[] arr, int target, Boolean[][] dp, int index) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[0] == target;
        }

        if (index < 0) {
            return false;
        }

        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean notTake = helper(arr, target, dp, index - 1);
        boolean take = false;
        if (arr[index] <= target) {
            take = helper(arr, target - arr[index], dp, index - 1);
        }

        return dp[index][target] = take || notTake;
    }

    // TABULATION
    // TC: O(N x K)
    // SC: O(N x K)
    public static boolean subsetSumToK1(int n, int k, int arr[]) {
        boolean dp[][] = new boolean[n][k + 1];

        for (boolean[] row : dp) {
            Arrays.fill(row, false);
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= k; t++) {
                boolean notTake = dp[i - 1][t];
                boolean take = false;
                if (arr[i] <= t) {
                    take = dp[i - 1][t - arr[i]];
                }
                dp[i][t] = take || notTake;
            }
        }

        return dp[n - 1][k];
    }

    // SPACE OPT
    // TC: O(N x K)
    // SC: O(N)
    public static boolean subsetSumToK2(int n, int k, int arr[]) {
        boolean prev[] = new boolean[k + 1];

        for (int i = 0; i < n; i++) {
            prev[0] = true;
        }

        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            boolean curr[] = new boolean[k + 1];
            for (int t = 1; t <= k; t++) {
                boolean notTake = prev[t];
                boolean take = false;
                if (arr[i] <= t) {
                    take = prev[t - arr[i]];
                }
                curr[t] = take || notTake;
            }
            prev = curr;
        }

        return prev[k];
    }
}
