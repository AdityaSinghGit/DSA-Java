package dp.subSet;

import java.util.Arrays;

public class WaysToMakeCoinChange {
    // https://www.naukri.com/code360/problems/ways-to-make-coin-change_630471?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
    public static long countWaysToMakeChange(int denominations[], int value) {
        long[][] dpArr = new long[denominations.length][value + 1];
        int n = denominations.length;

        for (long[] rows : dpArr) {
            Arrays.fill(rows, -1); // APPROACH 1
            // Arrays.fill(rows, 0); // APPROACH 2
        }

        return helper(n - 1, value, denominations, dpArr);
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
    public static long countWaysToMakeChange2(int denominations[], int value) {
        long[][] dpArr = new long[denominations.length][value + 1];
        int n = denominations.length;

        for (long[] rows : dpArr) {
            // Arrays.fill(rows, -1); // APPROACH 1
            Arrays.fill(rows, 0); // APPROACH 2
        }

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

    public static void main(String[] args) {
        int[] denominations = { 1, 2, 3 };
        long ans = countWaysToMakeChange2(denominations, 4);
        System.out.println(ans);
    }
}
