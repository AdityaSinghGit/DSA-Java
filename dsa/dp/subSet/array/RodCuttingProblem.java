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

    // APPROACH 1 : Recursion and Modulation
    public static int cutRod(int price[], int n) {
        int[][] dpArr = new int[price.length][n + 1];

        for (int[] rows : dpArr) {
            Arrays.fill(rows, -1);
        }

        return helper(price.length - 1, n, price, dpArr);
    }

    private static int helper(int index, int target, int[] price, int[][] dpArr) {
        if (index == 0) {
            return target * price[0];
        }

        if (dpArr[index][target] != -1) {
            return dpArr[index][target];
        }

        int notTake = 0 + helper(index - 1, target, price, dpArr);
        int take = Integer.MIN_VALUE;
        if (target >= (index + 1)) {
            take = price[index] + helper(index, target - (index + 1), price, dpArr);
        }

        dpArr[index][target] = Math.max(take, notTake);
        return dpArr[index][target];
    }

    // APPROACH 2 : Tabulation
    public static int cutRod2(int price[], int n) {
        int[][] dpArr = new int[price.length][n + 1];

        for (int[] rows : dpArr) {
            Arrays.fill(rows, 0);
        }

        for (int target = 0; target <= n; target++) {
            dpArr[0][target] = target * price[0];
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= n; target++) {
                int notTake = dpArr[index - 1][target];
                int take = Integer.MIN_VALUE;
                if (target >= (index + 1)) {
                    take = price[index] + dpArr[index][target - (index + 1)];
                }
                dpArr[index][target] = Math.max(notTake, take);
            }
        }

        return dpArr[price.length - 1][n];
    }

}
