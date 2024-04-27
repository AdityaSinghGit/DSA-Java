package dp.dp_2D;

import java.util.Arrays;

public class MinimumPathSum64 {
    // Leetcode 64
    // https://leetcode.com/problems/minimum-path-sum/description/

    // TIME : O(m*n)
    // SPACE : O((m-1) + (n-1))(Rec Stack) + O(m*n)(dp)
    public static void main(String[] args) {
        // int[][] grid = { { 1, 2, 3 }, { 4, 5, 4 }, { 4, 5, 9 } }; // 19
        int[][] grid = { { 5, 9, 6 }, { 11, 5, 2 } }; // 21

        int ans = minSumPath(grid);

        System.out.println(ans);
    }

    public static int minSumPath(int[][] grid) {
        int[][] dpArr = new int[grid.length][grid[0].length];

        for (int[] rows : dpArr) {
            Arrays.fill(rows, -1);
        }
        return countSumPath(grid.length - 1, grid[0].length - 1, dpArr, grid);
    }

    public static int countSumPath(int r, int c, int[][] dpArr, int[][] grid) {
        if (r == 0 && c == 0) {
            return grid[r][c];
        }

        if (r < 0 || c < 0) {
            return 1000000; // return large value
        }

        if (dpArr[r][c] != -1) {
            return dpArr[r][c];
        }

        int up = grid[r][c] + countSumPath(r - 1, c, dpArr, grid);
        int left = grid[r][c] + countSumPath(r, c - 1, dpArr, grid);

        dpArr[r][c] = Math.min(up, left);

        return dpArr[r][c];

    }
}
