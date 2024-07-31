package dp.subSet;

import java.util.Arrays;

public class EditDistance72 {
    // APPROACH 1: RECURSION AND MEMOIZATION
    // TC: O(N x M)
    // SC: O(N x M) + O(N + M) {Recursive stack space}
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dpArr = new int[n][m];

        for (int rows[] : dpArr) {
            Arrays.fill(rows, -1);
        }

        return helper(n - 1, m - 1, word1, word2, dpArr);
    }

    private int helper(int i, int j, String s1, String s2, int[][] dpArr) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        if (dpArr[i][j] != -1) {
            return dpArr[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 0 + helper(i - 1, j - 1, s1, s2, dpArr);
        }

        return dpArr[i][j] = Math.min(1 + helper(i - 1, j - 1, s1, s2, dpArr),
                Math.min(1 + helper(i - 1, j, s1, s2, dpArr), 1 + helper(i, j - 1, s1, s2, dpArr)));
    }

    // APPROACH 2: TABULATION
    public int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dpArr = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dpArr[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dpArr[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dpArr[i][j] = dpArr[i - 1][j - 1];
                } else {
                    dpArr[i][j] = 1 + Math.min(dpArr[i - 1][j - 1],
                            Math.min(dpArr[i - 1][j],
                                    dpArr[i][j - 1]));
                }

            }
        }

        return dpArr[n][m];
    }
}
