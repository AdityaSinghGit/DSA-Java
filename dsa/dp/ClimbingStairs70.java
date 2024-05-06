package dp;

import java.util.Arrays;

public class ClimbingStairs70 {
    // Leetcode 70
    // https://leetcode.com/problems/climbing-stairs/description/
    public static void main(String[] args) {
        int n = 3;
        // int ans = climbStairs(n);
        int ans = climbStairs2(n);
        System.out.println(ans);
    }

    // APPROACH 1 : R & M
    public static int climbStairs(int n) {
        int[] dpArr = new int[n];
        Arrays.fill(dpArr, -1);
        return helper(n, dpArr);
    }

    private static int helper(int n, int[] dpArr) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (dpArr[n - 1] != -1) {
            return dpArr[n - 1];
        }

        int oneStep = helper(n - 1, dpArr);

        int twoStep = helper(n - 2, dpArr);

        return dpArr[n - 1] = oneStep + twoStep;
    }

    // APPROACH 2 : Tabulation
    public static int climbStairs2(int n) {
        int[] dpArr = new int[n];
        Arrays.fill(dpArr, -1);

        dpArr[0] = 1;

        int oneStep = 0;
        int twoStep = 0;
        for (int i = 1; i < n; i++) {
            oneStep = dpArr[i];

            if (i > 1) {
                twoStep = dpArr[i - 1];
            }

            dpArr[i] = oneStep + twoStep;
        }

        return dpArr[n - 1];
    }
}
