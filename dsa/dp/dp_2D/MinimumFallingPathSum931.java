package dp.dp_2D;

import java.util.Arrays;

public class MinimumFallingPathSum931 {
    // Leetcode 931
    // https://leetcode.com/problems/minimum-falling-path-sum/description/

    // TIME : O(3^n)
    // SPACE : O(n)
    public static void main(String[] args) {
        // int[][] grid = { { 1, 2, 10, 4 }, { 100, 3, 2, 1 }, { 1, 1, 20, 2 }, { 1, 2,
        // 2, 1 } }; // 105
        int[][] grid = { { 10, 10, 2, -13, 20, 4 }, { 1, -9, -81, 30, 2, 5 }, { 0, 10, 4, -79, 2, -10 },
                { 1, -5, 2, 20, -11, 4 } }; // 74

        int ans = getMaxPathSum2(grid);

        System.out.println(ans);
    }

    // R & M
    // TIME : O(m*n)
    // SPACE : O(n) + O(m*n)(dp)
    public static int getMaxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -100000);
        }

        int maxi = -100000;
        for (int j = 0; j < n; j++) {
            maxi = Math.max(maxi, helper(m - 1, j, matrix, dp));
        }

        return maxi;
    }

    private static int helper(int i, int j, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= matrix[0].length) {
            return -100000;
        }
        if (i == 0) {
            return matrix[0][j];
        }

        if (dp[i][j] != -100000) {
            return dp[i][j];
        }

        int up = matrix[i][j] + helper(i - 1, j, matrix, dp);
        int left = matrix[i][j] + helper(i - 1, j - 1, matrix, dp);
        int right = matrix[i][j] + helper(i - 1, j + 1, matrix, dp);

        return dp[i][j] = Math.max(up, Math.max(left, right));
    }

    // Tabulation
    // TIME : O(m*n)
    // SPACE : O(m*n)
    public static int getMaxPathSum1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int left = -100000;
                int right = -100000;
                if (j > 0)
                    left = matrix[i][j] + dp[i - 1][j - 1];
                if (j < n - 1)
                    right = matrix[i][j] + dp[i - 1][j + 1];

                dp[i][j] = Math.max(up, Math.max(left, right));
            }
        }

        int maxi = -100000;
        for (int j = 0; j < n; j++) {
            maxi = Math.max(maxi, dp[m - 1][j]);
        }

        return maxi;
    }

    // Space optimization
    // TIME : O(m*n)
    // SPACE : O(n)
    public static int getMaxPathSum2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] prev = new int[n];

        for (int j = 0; j < n; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + prev[j];
                int left = -100000;
                int right = -100000;
                if (j > 0)
                    left = matrix[i][j] + prev[j - 1];
                if (j < n - 1)
                    right = matrix[i][j] + prev[j + 1];

                curr[j] = Math.max(up, Math.max(left, right));
            }
            prev = curr;
        }

        int maxi = -100000;
        for (int j = 0; j < n; j++) {
            maxi = Math.max(maxi, prev[j]);
        }

        return maxi;
    }
}
