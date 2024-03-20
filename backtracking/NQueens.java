package backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int ans = showCount(board, 0);
        System.out.println(ans);
    }

    // Returns number of ways queen can be placed in n x n board
    public static int showCount(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.err.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += showCount(board, row + 1);
                board[row][col] = false; // backtracking
            }
        }
        return count;
    }

    // To check if queen can be placed or not
    static boolean isSafe(boolean[][] board, int row, int col) {
        // Check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // Check diagonal left
        int diagLeft = Math.min(row, col);
        for (int i = 1; i <= diagLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // Check diagonal Right
        int diagRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= diagRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    // This displays Q and X in place of true and false
    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

}
