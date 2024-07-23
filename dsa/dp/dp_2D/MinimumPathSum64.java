package dp.dp_2D;

import java.util.Arrays;

public class MinimumPathSum64 {
    // Leetcode 64
    // https://leetcode.com/problems/minimum-path-sum/description/

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }; // 7
        // int[][] grid = { { 5, 9, 6 }, { 11, 5, 2 } }; // 21

        int ans = minPathSum2(grid);

        System.out.println(ans);
    }

    // R & M
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        return helper(m - 1, n - 1, dp, grid);
    }

    public static int helper(int i, int j, int[][] dp, int[][] grid) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return 1000000;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int left = grid[i][j] + helper(i, j - 1, dp, grid);
        int up = grid[i][j] + helper(i - 1, j, dp, grid);

        return dp[i][j] = Math.min(left, up);
    }

    // TABULATION
    public static int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else {
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;
                    if (i > 0) {
                        up = grid[i][j] + dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = grid[i][j] + dp[i][j - 1];
                    }

                    dp[i][j] = Math.min(left, up);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // SPACE OPTIMIZATION
    public static int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else {
                    int left = Integer.MAX_VALUE;
                    int up = Integer.MAX_VALUE;
                    if (i > 0) {
                        up = grid[i][j] + prev[j];
                    }
                    if (j > 0) {
                        left = grid[i][j] + curr[j - 1];
                    }

                    curr[j] = Math.min(left, up);
                }
            }
            prev = curr;
        }
        return prev[n - 1];
    }
}
