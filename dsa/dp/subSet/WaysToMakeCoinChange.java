package dp.subSet;

import java.util.Arrays;

public class WaysToMakeCoinChange {
    // https://www.naukri.com/code360/problems/ways-to-make-coin-change_630471?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
    public static long countWaysToMakeChange(int denominations[], int value) {
        long[][] dpArr = new long[denominations.length][value + 1];
        int n = denominations.length;

        for (long[] rows : dpArr) {
            // Arrays.fill(rows, -1); // for helper
            Arrays.fill(rows, 0); // for helper2
        }

        // return helper(n - 1, value, denominations, dpArr); // APPROACH 1
        return helper2(n, value, denominations, dpArr); // APPROACH 2
    }

    // APPROACH 1 : Recursion & Memoization
    private static long helper(int index, int target, int[] nums, long[][] dpArr) {
        if (index == 0) {
            if (target % nums[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dpArr[index][target] != -1) {
            return dpArr[index][target];
        }

        long notTake = helper(index - 1, target, nums, dpArr);
        long take = 0;
        if (nums[index] <= target) {
            take = helper(index, target - nums[index], nums, dpArr);
        }

        dpArr[index][target] = notTake + take;

        return dpArr[index][target];
    }

    // APPROACH 2 : Tabulation
    private static long helper2(int index, int target, int[] nums, long[][] dpArr) {
        for (int t = 0; t <= target; t++) {
            dpArr[0][t] = t % nums[0] == 0 ? 1 : 0;
        }

        for (int i = 1; i < index; i++) {
            for (int t = 0; t <= target; t++) {
                long notTake = dpArr[i - 1][t];
                long take = 0;
                if (nums[i] <= t) {
                    take = dpArr[i][t - nums[i]];
                }
                dpArr[i][t] = notTake + take;
            }
        }
        return dpArr[index - 1][target];
    }

    public static void main(String[] args) {
        int[] denominations = { 1, 2, 3 };
        long ans = countWaysToMakeChange(denominations, 4);
        System.out.println(ans);
    }
}
