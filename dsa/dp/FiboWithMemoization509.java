package dp;

public class FiboWithMemoization509 {
    public static void main(String[] args) {
        System.out.println((long) fib(40));
    }

    // Leetcode 509
    // https://leetcode.com/problems/fibonacci-number/description/
    public static int fib(int n) {
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
}
