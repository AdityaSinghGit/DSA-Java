package dp;

import java.util.Arrays;

public class ClimbingStairs70 {
    // Leetcode 70
    // https://leetcode.com/problems/climbing-stairs/description/
    public static void main(String[] args) {
        int n = 3;
        int ans = climbStairs(n);
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

        for (int i = 0; i <= n; i++)

            return helper(n, dpArr);
    }
}
