package dp.subSet.strings;

import java.util.Arrays;

public class LongestCommonSubsequence1143 {
    // Leetcode 1143
    // https://leetcode.com/problems/longest-common-subsequence/description/
    public static void main(String[] args) {

    }

    // APPROACH 1 : R & M
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dpArr = new int[n][m];
        for (int[] rows : dpArr) {
            Arrays.fill(rows, -1);
        }
        return helper(n - 1, m - 1, text1, text2, dpArr);
    }

    private static int helper(int n, int m, String text1, String text2, int[][] dpArr) {
        if (n < 0 || m < 0) {
            return 0;
        }

        if (dpArr[n][m] != -1) {
            return dpArr[n][m];
        }

        int noMatch = Math.max(helper(n - 1, m, text1, text2, dpArr), helper(n, m - 1, text1, text2, dpArr));
        int match = Integer.MIN_VALUE;
        if (text1.charAt(n) == text2.charAt(m)) {
            match = 1 + helper(n - 1, m - 1, text1, text2, dpArr);
        }

        return dpArr[n][m] = Math.max(match, noMatch);
    }

    // APPROACH 2 : Tabulation
    // (For explaination, watch striver DP25 lecture)
    // https://www.youtube.com/watch?v=NPZn9jBrX8U&list=PLgUwDviBIf0pwFf-BnpkXxs0Ra0eU2sJY&index=16
    public int longestCommonSubsequence2(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // We incremented n and m bcz the base case is checking if n || m is -1
        // but we cannot check for that so we increment n and m by 1
        int[][] dpArr = new int[n + 1][m + 1];
        for (int[] rows : dpArr) {
            Arrays.fill(rows, 0);
        }

        for (int M = 0; M <= m; M++) {
            dpArr[0][M] = 0;
        }
        for (int N = 0; N <= n; N++) {
            dpArr[N][0] = 0;
        }

        for (int N = 1; N <= n; N++) {
            for (int M = 1; M <= m; M++) {
                int noMatch = Math.max(dpArr[N - 1][M], dpArr[N][M - 1]);
                int match = Integer.MIN_VALUE;
                if (text1.charAt(N - 1) == text2.charAt(M - 1)) {
                    match = 1 + dpArr[N - 1][M - 1];
                }

                dpArr[N][M] = Math.max(match, noMatch);
            }
        }

        return dpArr[n][m];
    }
}
