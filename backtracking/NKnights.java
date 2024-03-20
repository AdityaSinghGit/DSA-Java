package backtracking;

public class NKnights {
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        int ans = showCount(board, 0, 0, 3);
        System.out.println(ans);
    }

    // Returns number of ways queen can be placed in n x n board
    public static int showCount(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return 1;
        }

        if (row == board.length - 1 && col == board.length) {
            return 1;
        }

        int count = 0;
        if (col == board.length) {
            count += showCount(board, row + 1, 0, knights);
            return 1;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count += showCount(board, row, col + 1, knights - 1);
            board[row][col] = false; // backtracking
        }

        count += showCount(board, row, col + 1, knights);

        return count;
    }

    // To check if queen can be placed or not
    static boolean isSafe(boolean[][] board, int row, int col) {
        // Check row - 2, col - 1
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        // Check row - 2, col + 1
        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        // Check row - 1, col + 2
        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        // Check row - 1, col - 2
        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        return true;
    }

    // Check if index for row or col is not out of bound
    static boolean isValid(boolean[][] board, int row, int col) {
        if (row < board.length && row >= 0 && col < board.length && col >= 0) {
            return true;
        }
        return false;
    }

    // This displays Q and X in place of true and false
    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
