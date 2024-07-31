package dp.subSet;

import java.util.Arrays;

public class WaysToMakeCoinChange {
    // https://www.naukri.com/code360/problems/ways-to-make-coin-change_630471?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM

    // TC: O(exponential)
    // SC: greater than O(N) OR O(Target) : bcz we're iterating on the same position

    // APPROACH 1 : Recursion & Memoization
    // TC: O(N x M)
    // SC: O(N x M) + O(Target)
    public static long countWaysToMakeChange(int denominations[], int value) {
        int n = denominations.length;
        long[][] dp = new long[n][value + 1];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, value, denominations, dp);
    }

    private static long helper(int ind, int val, int[] arr, long[][] dp) {
        if (ind == 0) {
            if (val % arr[ind] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[ind][val] != -1) {
            return dp[ind][val];
        }

        long notTake = helper(ind - 1, val, arr, dp);
        long take = 0;
        if (val >= arr[ind]) {
            take = helper(ind, val - arr[ind], arr, dp);
        }

        return dp[ind][val] = take + notTake;
    }

    // APPROACH 2 : Tabulation
    // TC: O(N x M)
    // SC: O(N x M)
    public static long countWaysToMakeChange2(int denominations[], int value) {
        long[][] dpArr = new long[denominations.length][value + 1];
        int n = denominations.length;

        for (int target = 0; target <= value; target++) {
            if (target % denominations[0] == 0) {
                dpArr[0][target] = 1;
            } else {
                dpArr[0][target] = 0;
            }
        }

        for (int index = 1; index < denominations.length; index++) {
            for (int target = 0; target <= value; target++) {
                long notTake = dpArr[index - 1][target];
                long take = 0;
                if (denominations[index] <= target) {
                    take = dpArr[index][target - denominations[index]];
                }

                dpArr[index][target] = notTake + take;
            }
        }

        return dpArr[n - 1][value];
    }

    // APPROACH 3 : Space opt
    // TC: O(N x M)
    // SC: O(N)
    public static long countWaysToMakeChange3(int denominations[], int value) {
        long[] prev = new long[value + 1];

        for (int target = 0; target <= value; target++) {
            if (target % denominations[0] == 0) {
                prev[target] = 1;
            } else {
                prev[target] = 0;
            }
        }

        for (int index = 1; index < denominations.length; index++) {
            long[] curr = new long[value + 1];
            for (int target = 0; target <= value; target++) {
                long notTake = prev[target];
                long take = 0;
                if (denominations[index] <= target) {
                    take = curr[target - denominations[index]];
                }

                curr[target] = notTake + take;
            }
            prev = curr;
        }

        return prev[value];
    }

    public static void main(String[] args) {
        int[] denominations = { 1, 2, 3 };
        long ans = countWaysToMakeChange3(denominations, 4);
        System.out.println(ans);
    }
}
