package dp.dp_2D;

import java.util.Arrays;

public class UniquePaths62 {
    // consider notes and this video
    // https://www.youtube.com/watch?v=sdE0A2Oxofw&list=PLgUwDviBIf0pwFf-BnpkXxs0Ra0eU2sJY&index=5
    // leetcode 62 :
    // https://leetcode.com/problems/unique-paths/submissions/1322706967/

    // Approach 1 : R & M
    // TIME : O(m*n)
    // SPACE : O((m-1) + (n-1))(Rec Stack) + O(m*n)(dp)
    public int uniquePaths(int m, int n) {
        int[][] dpArr = new int[m][n];

        for (int[] rows : dpArr) {
            Arrays.fill(rows, -1);
        }

        return helper(m - 1, n - 1, dpArr);
    }

    private int helper(int i, int j, int[][] dpArr) {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;

        if (dpArr[i][j] != -1)
            return dpArr[i][j];

        int up = helper(i - 1, j, dpArr);
        int left = helper(i, j - 1, dpArr);

        return dpArr[i][j] = left + up;
    }

    // Approach 2 : Tabulation
    // TIME : O(m*n)
    // SPACE : O(m*n)
    public int uniquePaths1(int m, int n) {
        int[][] dpArr = new int[m][n];

        dpArr[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0)
                        up = dpArr[i - 1][j];
                    if (j > 0)
                        left = dpArr[i][j - 1];

                    dpArr[i][j] = left + up;
                }
            }
        }
        return dpArr[m - 1][n - 1];
    }

    // Approach 3 : Space Optimization
    // TIME : O(m*n)
    // SPACE : O(n)
    public int uniquePaths2(int m, int n) {
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                } else {
                    int up = 0;
                    int left = 0;
                    if (i > 0)
                        up = prev[j];
                    if (j > 0)
                        left = temp[j - 1];

                    temp[j] = left + up;

                }
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}
