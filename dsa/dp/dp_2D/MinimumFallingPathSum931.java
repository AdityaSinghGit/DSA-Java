package dp.dp_2D;

import java.util.Arrays;

public class MinimumFallingPathSum931 {
    // Leetcode 931
    // https://leetcode.com/problems/minimum-falling-path-sum/description/

    // TIME : O(m*n)
    // SPACE : O((m-1) + (n-1))(Rec Stack) + O(m*n)(dp)
    public static void main(String[] args) {
        // int[][] grid = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } }; // 13
        // int[][] grid = { { -19, 57 }, { -40, -5 } }; // -59
        // int[][] grid = { { -84, -36, 2 }, { 87, -79, 10 }, { 42, 10, 63 } }; // -153
        int[][] grid = { { -80, -13, 22 }, { 83, 94, -5 }, { 73, -48, 61 } }; // -66

        int ans = minFallingPathSum(grid);

        System.out.println(ans);
    }

    public static int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        int[][] dpArr = new int[matrix.length][matrix[0].length];

        for (int[] rows : dpArr) {
            Arrays.fill(rows, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            ans = Math.min(ans, pathSum(0, i, dpArr, matrix));
        }

        return ans;
    }

    private static int pathSum(int r, int c, int[][] dpArr, int[][] matrix) {
        if ((r == matrix.length - 1 && c > -1 && c < matrix[0].length))
            return matrix[r][c];

        if (r > matrix.length || c > matrix.length - 1 || c < 0) {
            return 100000;
        }

        if (dpArr[r][c] != Integer.MAX_VALUE) {
            return dpArr[r][c];
        }

        int down = matrix[r][c] + pathSum(r + 1, c, dpArr, matrix);
        int diagLeft = matrix[r][c] + pathSum(r + 1, c - 1, dpArr, matrix);
        int diagRight = matrix[r][c] + pathSum(r + 1, c + 1, dpArr, matrix);

        dpArr[r][c] = Math.min(diagLeft, diagRight);
        dpArr[r][c] = Math.min(down, dpArr[r][c]);

        return dpArr[r][c];
    }
}
