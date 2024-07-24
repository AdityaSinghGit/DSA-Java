package dp.subSet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ***************VERY IMPORTANT*****************
public class Knapsack01 {
    // https://www.naukri.com/code360/problems/0-1-knapsack_1072980?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM

    // Before Memoization
    // TC: 2^n
    // SC: O(n)

    // METHOD 1: RECURSION AND MEMOIZATION (TOP - DOWN)
    // TC: O(N x W) {N elements and W weights}
    // SC: O(N x W) + O(N) {recursion stack space}
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[][] dpArr = new int[n][w + 1];

        for (int[] rows : dpArr) {
            Arrays.fill(rows, -1);
        }

        return helper(n - 1, w, weights, values, dpArr);

    }

    private static int helper(int index, int maxWeight, ArrayList<Integer> weight, ArrayList<Integer> value,
            int[][] dpArr) {
        if (index == 0) {
            if (weight.get(0) <= maxWeight)
                return value.get(0);
            else
                return 0;
        }

        if (dpArr[index][maxWeight] != -1) {
            return dpArr[index][maxWeight];
        }

        int notTake = 0 + helper(index - 1, maxWeight, weight, value, dpArr);
        int take = Integer.MIN_VALUE;
        if (weight.get(index) <= maxWeight) {
            take = value.get(index) + helper(index - 1, maxWeight - weight.get(index), weight, value, dpArr);
        }

        return dpArr[index][maxWeight] = Math.max(take, notTake);
    }

    // METHOD 2: TABULATION (BOTTOM - UP)
    // TC: O(N x W)
    // SC: O(N x W)
    public static int maxProfit1(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int maxWeight) {
        int[][] dpArr = new int[n][maxWeight + 1];

        for (int W = weights.get(0); W <= maxWeight; W++) {
            dpArr[0][W] = values.get(0);
        }

        for (int index = 1; index < n; index++) {
            for (int W = 0; W <= maxWeight; W++) {
                int notTake = 0 + dpArr[index - 1][W];
                int take = Integer.MIN_VALUE;
                if (weights.get(index) <= W) {
                    take = values.get(index)
                            + dpArr[index - 1][W - weights.get(index)];
                }

                dpArr[index][W] = Math.max(take, notTake);
            }
        }

        return dpArr[n - 1][maxWeight];
    }

    // METHOD 3: SPACE OPTIMIZATION
    // TC: O(N x W)
    // SC: O(N)
    public static int maxProfit2(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int maxWeight) {
        int[][] dpArr = new int[n][maxWeight + 1];

        for (int W = weights.get(0); W <= maxWeight; W++) {
            dpArr[0][W] = values.get(0);
        }

        for (int index = 1; index < n; index++) {
            for (int W = 0; W <= maxWeight; W++) {
                int notTake = 0 + dpArr[index - 1][W];
                int take = Integer.MIN_VALUE;
                if (weights.get(index) <= W) {
                    take = values.get(index)
                            + dpArr[index - 1][W - weights.get(index)];
                }

                dpArr[index][W] = Math.max(take, notTake);
            }
        }

        return dpArr[n - 1][maxWeight];
    }

    public static void main(String[] args) {
        ArrayList<Integer> weights = new ArrayList<>(List.of(12, 35, 41, 25, 32));
        ArrayList<Integer> values = new ArrayList<>(List.of(20, 24, 36, 40, 42));
        int ans = maxProfit1(weights, values, 5, 100);
        System.out.println(ans);
    }

}
