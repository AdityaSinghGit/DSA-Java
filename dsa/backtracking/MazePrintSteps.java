package backtracking;

import java.util.Arrays;

public class MazePrintSteps {
    public static void main(String[] args) {
        boolean[][] board = {
                { true, true, true },
                { true, true, true },
                { true, true, true },
        };
        int[][] path = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 },
        };
        showPathNumber("", board, 0, 0, path, 0);
    }

    static void showPathNumber(String p, boolean[][] board, int r, int c, int[][] path, int step) {
        if (r == board.length - 1 && c == board[0].length - 1) {
            for (int[] n : path) {
                System.out.println(Arrays.toString(n));
            }
            return;
        }

        if (!board[r][c]) {
            return;
        }

        /******** IMPORTANT **********/
        // This is marked false bcz if we have already been to the cell.
        // recursion will again come to this cell which will create an endless loop.
        // Therefore, mark as false so recursion call will not revisit the cell.
        // I am considering this block in my path.
        board[r][c] = false;
        path[r][c] = step;

        if (r < board.length - 1) {
            showPathNumber(p + 'D', board, r + 1, c, path, step + 1);
        }
        if (c < board[0].length - 1) {
            showPathNumber(p + 'R', board, r, c + 1, path, step + 1);
        }
        if (r > 0) {
            showPathNumber(p + 'U', board, r - 1, c, path, step + 1);
        }
        if (c > 0) {
            showPathNumber(p + 'L', board, r, c - 1, path, step + 1);
        }

        /******** ****BACKTRACKING**** **********/
        // This is again marked true bcz we might need to return to this cell.
        // This line is where the function will be over.
        // So, before the function gets removed, restore the changes made by that fn.
        board[r][c] = true;
        path[r][c] = 0;

    }

}
