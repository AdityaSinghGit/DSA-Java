package dp.subSet;

import java.util.ArrayList;
import java.util.Arrays;

// ***************VERY IMPORTANT*****************
public class Knapsack01 {
    // https://www.naukri.com/code360/problems/0-1-knapsack_1072980?interviewProblemRedirection=true&leftPanelTabValue=PROBLEM
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
}
