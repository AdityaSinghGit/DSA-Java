package dp.dp_1D;

public class FiboWithMemoization509 {
    // Leetcode 509
    // https://leetcode.com/problems/fibonacci-number/description/
    public static void main(String[] args) {
        System.out.println((long) fib1(5));
    }

    // APPROACH 1 - Recursion & Memoization - TOP-DOWN
    // O(n) (for the recursion stack) + O(n) (for memoization data structure) = O(n)
    public static int fib1(int n) {
        int[] dpArr = new int[n + 1];

        for (int i = 0; i < dpArr.length; i++) {
            dpArr[i] = -1;
        }

        return findFibo(n, dpArr);
    }

    private static int findFibo(int n, int[] dpArr) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dpArr[n] != -1) {
            return dpArr[n]; // If already saved then return
        }

        dpArr[n] = findFibo(n - 1, dpArr) + findFibo(n - 2, dpArr);

        return dpArr[n];
    }

    // APPROACH 2 - Tabulation - BOTTOM - UP
    public static int fib2(int n) {
        int[] dpArr = new int[n + 1];

        for (int i = 0; i < dpArr.length; i++) {
            dpArr[i] = -1;
        }

        dpArr[0] = 0;
        dpArr[1] = 1;
        for (int i = 2; i < dpArr.length; i++) {
            dpArr[i] = dpArr[i - 1] + dpArr[i - 2];
        }

        return dpArr[n];
    }

    // APPROACH 3 - Space Optimization
    public static int fib3(int n) {

        int prev1 = 1;
        int prev2 = 0;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
