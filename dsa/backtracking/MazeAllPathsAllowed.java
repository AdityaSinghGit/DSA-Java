package backtracking;

public class MazeAllPathsAllowed {
    public static void main(String[] args) {
        boolean[][] board = {
                { true, true, true },
                { true, true, true },
                { true, true, true },
        };
        mazeAllDirections("", board, 0, 0);
    }

    static void mazeAllDirections(String p, boolean[][] board, int r, int c) {
        if (r == board.length - 1 && c == board[0].length - 1) {
            System.out.println(p);
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

        if (r < board.length - 1) {
            mazeAllDirections(p + 'D', board, r + 1, c);
        }
        if (c < board[0].length - 1) {
            mazeAllDirections(p + 'R', board, r, c + 1);
        }
        if (r > 0) {
            mazeAllDirections(p + 'U', board, r - 1, c);
        }
        if (c > 0) {
            mazeAllDirections(p + 'L', board, r, c - 1);
        }

        /******** ****BACKTRACKING**** **********/
        // This is again marked true bcz we might need to return to this cell.
        // This line is where the function will be over.
        // So, before the function gets removed, restore the changes made by that fn.
        board[r][c] = true;

    }

}
