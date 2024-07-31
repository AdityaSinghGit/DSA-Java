package dp.strings;

import java.util.Arrays;

public class LongestCommonSubsequence1143 {
    // Leetcode 1143
    // https://leetcode.com/problems/longest-common-subsequence/description/
    // For sol
    // https://www.youtube.com/watch?v=NPZn9jBrX8U&list=PLgUwDviBIf0pwFf-BnpkXxs0Ra0eU2sJY&index=12

    // TC: O(2^n + 2^m)
    // SC: O(exp)
    public static void main(String[] args) {

    }

    // APPROACH 1 : R & M
    // TC: O(N x M)
    // SC: O(N x M) + O(N + M) Recursive stack space
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
    // TC: O(N x M)
    // SC: O(N x M)
    public int longestCommonSubsequence2(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // We incremented n and m bcz the base case is checking if n || m is -1
        // but we cannot check for that so we increment n and m by 1
        int[][] dpArr = new int[n + 1][m + 1];
        for (int[] rows : dpArr) {
            Arrays.fill(rows, 0);
        }

        for (int j = 0; j <= m; j++) {
            dpArr[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dpArr[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int noMatch = Math.max(dpArr[i - 1][j], dpArr[i][j - 1]);
                int match = Integer.MIN_VALUE;
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    match = 1 + dpArr[i - 1][j - 1];
                }

                dpArr[i][j] = Math.max(match, noMatch);
            }
        }

        return dpArr[n][m];
    }

    // APPROACH 3 : Space Opt
    // TC: O(N x M)
    // SC: O(N)
    public static int getLengthOfLCS(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[] prev = new int[m + 1];

        for (int j = 0; j <= m; j++) {
            prev[j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                int notTake = Math.max(prev[j], curr[j - 1]);
                int take = Integer.MIN_VALUE;
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    take = 1 + prev[j - 1];
                }

                curr[j] = Math.max(take, notTake);
            }
            prev = curr;
        }

        return prev[m];
    }
}
