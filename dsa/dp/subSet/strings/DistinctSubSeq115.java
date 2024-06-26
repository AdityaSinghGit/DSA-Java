package dp.subSet.strings;

import java.util.Arrays;

public class DistinctSubSeq115 {
    // https://leetcode.com/problems/distinct-subsequences/

    // APPROACH 1: Recursion and Memoization
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dpArr = new int[n][m];

        for (int row[] : dpArr) {
            Arrays.fill(row, -1);
        }

        return helper(n - 1, m - 1, s, t, dpArr);
    }

    private int helper(int i, int j, String s, String t, int[][] dpArr) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;

        if (dpArr[i][j] != -1) {
            return dpArr[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            return (helper(i - 1, j - 1, s, t, dpArr) + helper(i - 1, j, s, t, dpArr));
        }

        return helper(i - 1, j, s, t, dpArr);
    }

    // APPROACH 2: Tabulation
    public int numDistinct1(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dpArr = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) { // here i = 0
            dpArr[i][0] = 1; // bcz j = 0
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dpArr[i][j] = dpArr[i - 1][j - 1] + dpArr[i - 1][j];
                } else {
                    dpArr[i][j] = dpArr[i - 1][j];
                }
            }
        }

        return dpArr[n][m];
    }
}
