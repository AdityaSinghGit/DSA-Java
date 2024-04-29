package dp.subSet;

import java.util.Arrays;

public class WaysToMakeCoinChange {
    // https://www.naukri.com/code360/problems/ways-to-make-coin-change_630471?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
    public static long countWaysToMakeChange(int denominations[], int value) {
        long[][] dpArr = new long[denominations.length][value + 1];

        for (long[] rows : dpArr) {
            Arrays.fill(rows, -1);
        }

        return helper(denominations.length - 1, value, denominations, dpArr);
    }

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
}
