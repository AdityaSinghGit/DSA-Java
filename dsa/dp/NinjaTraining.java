package dp;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] points = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };
        int n = points.length;
        int ans = ninjaTraining(n, points);
        System.out.println(ans);

    }

    public static int ninjaTraining(int n, int points[][]) {
        int[][] dpArr = new int[n][4];
        for (int[] rows : dpArr) {
            Arrays.fill(rows, -1);
        }
        return maxTraining(n - 1, 3, points, dpArr);
    }

    private static int maxTraining(int curr, int last, int[][] task, int[][] dpArr) {
        if (dpArr[curr][last] != -1) {
            return dpArr[curr][last];
        }

        if (curr == 0) {
            int max = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    max = Math.max(max, task[0][i]);
                }
            }
            return max;
        }

        int max = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int points = task[curr][i] + maxTraining(curr - 1, i, task, dpArr);
                max = Math.max(max, points);
            }
        }
        dpArr[curr][last] = max;
        return dpArr[curr][last];
    }
}
