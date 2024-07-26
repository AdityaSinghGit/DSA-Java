package dp.subSet.array;

import java.util.Arrays;

public class RodCuttingProblem {
    // https://www.naukri.com/code360/problems/rod-cutting-problem_800284?interviewProblemRedirection=true&search=rod%20cutting%20&leftPanelTabValue=PROBLEM
    public static void main(String[] args) {
        // int[] price = { 3, 5, 8, 9, 10, 17, 17, 20 }; //24
        int[] price = { 42, 68, 35, 1, 70 }; // 210
        int pipeSize = 5; // price.length
        int ans = cutRod2(price, pipeSize);
        System.out.println(ans);
    }

    // TC: O(exponential)
    // SC: O(Target)

    // APPROACH 1 : Recursion and Modulation
    // TC: O(N x M)
    // SC: O(N X M) + O(Target)
    public static int cutRod(int price[], int n) {
        int[][] dp = new int[price.length][n + 1];

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        return helper(price.length - 1, n, price, dp);
    }

    private static int helper(int ind, int target, int[] price, int[][] dp) {
        if (ind == 0) {
            return target * price[0];
        }

        if (dp[ind][target] != -1) {
            return dp[ind][target];
        }

        int notTake = helper(ind - 1, target, price, dp);
        int take = Integer.MIN_VALUE;
        if (target >= ind + 1) {
            take = helper(ind, target - (ind + 1), price, dp) + price[ind];
        }

        return dp[ind][target] = Math.max(take, notTake);
    }

    // APPROACH 2 : Tabulation
    // TC: O(N x M)
    // SC: O(N X M)
    public static int cutRod1(int price[], int n) {
        int[][] dp = new int[price.length][n + 1];

        for (int target = 1; target <= n; target++) {
            dp[0][target] = target * price[0];
        }

        for (int ind = 1; ind < price.length; ind++) {
            for (int target = 1; target <= n; target++) {
                int notTake = dp[ind - 1][target];
                int take = Integer.MIN_VALUE;
                if (target >= ind + 1) {
                    take = dp[ind][target - (ind + 1)] + price[ind];
                }

                dp[ind][target] = Math.max(take, notTake);
            }
        }

        return dp[price.length - 1][n];
    }

    // APPROACH 3 : Space opt
    // TC: O(N x M)
    // SC: O(N)
    public static int cutRod2(int price[], int n) {
        int[] prev = new int[n + 1];

        for (int target = 1; target <= n; target++) {
            prev[target] = target * price[0];
        }

        for (int ind = 1; ind < price.length; ind++) {
            int[] curr = new int[n + 1];
            for (int target = 1; target <= n; target++) {
                int notTake = prev[target];
                int take = Integer.MIN_VALUE;
                if (target >= ind + 1) {
                    take = curr[target - (ind + 1)] + price[ind];
                }

                curr[target] = Math.max(take, notTake);
            }
            prev = curr;
        }

        return prev[n];
    }

}
