package dp.subSet;

public class WildcardMatching44 {
    // Problem :
    // https://leetcode.com/problems/wildcard-matching/
    // Explanation :
    // https://www.youtube.com/watch?v=ZmlQ3vgAOMo&list=PLgUwDviBIf0pwFf-BnpkXxs0Ra0eU2sJY&index=16
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); // Output: false
        System.out.println(isMatch("aa", "*")); // Output: true
        System.out.println(isMatch("cb", "?a")); // Output: false
        System.out.println(isMatch("adceb", "*a*b")); // Output: true
        System.out.println(isMatch("acdcb", "a*c?b")); // Output: false
    }

    // APPROACH 1: Recursion and Memoization
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        Boolean[][] dpArr = new Boolean[n][m];

        return helper(n - 1, m - 1, s, p, dpArr);
    }

    private static boolean helper(int i, int j, String s, String p, Boolean[][] dpArr) {
        if (i < 0 && j < 0)
            return true;
        if (i >= 0 && j < 0)
            return false;
        if (i < 0 && j >= 0) {
            for (int jj = 0; jj <= j; jj++) {
                if (p.charAt(jj) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dpArr[i][j] != null) {
            return dpArr[i][j];
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dpArr[i][j] = helper(i - 1, j - 1, s, p, dpArr);
        }
        if (p.charAt(j) == '*') {
            return dpArr[i][j] = helper(i - 1, j, s, p, dpArr) | helper(i, j - 1, s, p, dpArr);
        }

        return dpArr[i][j] = false;
    }

}
