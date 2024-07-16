package dp.dp_2D;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] points = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };
        int n = points.length;
        int ans = ninjaTraining2(n, points);
        System.out.println(ans);

    }

    // Recursion and Memoization
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dpArr = new int[n][points[0].length + 1];

        for (int[] rows : dpArr) {
            Arrays.fill(rows, -1);
        }

        return helper(n - 1, points[0].length, points, dpArr);
    }

    private static int helper(int day, int last, int[][] points, int[][] dpArr) {
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return maxi;
        }

        if (dpArr[day][last] != -1) {
            return dpArr[day][last];
        }

        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int calc = points[day][i] + helper(day - 1, i, points, dpArr);
                maxi = Math.max(maxi, calc);
            }
        }

        return dpArr[day][last] = maxi;
    }

    // Tabulation
    public static int ninjaTraining1(int n, int points[][]) {
        int lastLen = points[0].length;
        int[][] dpArr = new int[n][lastLen + 1];

        dpArr[0][0] = Math.max(points[0][1], points[0][2]);
        dpArr[0][1] = Math.max(points[0][0], points[0][2]);
        dpArr[0][2] = Math.max(points[0][0], points[0][1]);
        dpArr[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < lastLen + 1; last++) {
                dpArr[day][last] = 0;
                for (int i = 0; i < 3; i++) {
                    if (i != last) {
                        int calc = points[day][i] + dpArr[day - 1][i];
                        dpArr[day][last] = Math.max(dpArr[day][last], calc);
                    }
                }
            }
        }
        return dpArr[n - 1][lastLen];
    }

    // space optimization
    public static int ninjaTraining2(int n, int points[][]) {
        int lastLen = points[0].length;
        int[] prev = new int[lastLen + 1];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[lastLen + 1];
            for (int last = 0; last < lastLen + 1; last++) {
                temp[last] = 0;
                for (int i = 0; i < 3; i++) {
                    if (i != last) {
                        int calc = points[day][i] + prev[i];
                        temp[last] = Math.max(temp[last], calc);
                    }
                }
            }
            prev = temp;
        }
        return prev[lastLen];
    }
}
