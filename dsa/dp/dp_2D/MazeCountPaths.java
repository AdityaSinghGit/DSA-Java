package dp.dp_2D;

import java.util.Arrays;

public class MazeCountPaths {
    // TIME : O(m*n)
    // SPACE : O((m-1) + (n-1))(Rec Stack) + O(n)(dp)
    public static void main(String[] args) {
        int[][] dpArr = new int[3][3];

        for (int[] rows : dpArr) {
            Arrays.fill(rows, -1);
        }

        int ans = countPaths(2, 2, dpArr);

        System.out.println(ans);
    }

    public static int countPaths(int r, int c, int[][] dpArr) {
        if (r == 0 && c == 0) {
            return 1;
        }

        if (r < 0 || c < 0) {
            return 0;
        }

        if (dpArr[r][c] != -1) {
            return dpArr[r][c];
        }

        int up = countPaths(r - 1, c, dpArr);
        int left = countPaths(r, c - 1, dpArr);

        dpArr[r][c] = up + left;

        return dpArr[r][c];

    }

}
