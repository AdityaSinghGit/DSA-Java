package backtracking;

public class MazeWithObstacles {
    public static void main(String[] args) {

        // mazePathWithObstacles("", 0, 0);

        boolean[][] board = {
                { true, true, true },
                { true, false, true },
                { true, true, true },
        };
        mazeObstaclesBetter("", board, 0, 0);

        // mazePathWithObstaclesDiagonalAllowed("", 0, 0);
    }

    // PRINTS ALL PATHS TO REACH GOAL
    static void mazeObstaclesBetter(String p, boolean[][] board, int r, int c) {
        if (r == board.length - 1 && c == board[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!board[r][c]) {
            return;
        }
        if (r < board.length - 1) {
            mazeObstaclesBetter(p + 'D', board, r + 1, c);
        }
        if (c < board[0].length - 1) {
            mazeObstaclesBetter(p + 'R', board, r, c + 1);
        }

    }

    // PRINTS ALL PATHS TO REACH GOAL
    static void mazePathWithObstacles(String p, int r, int c) {
        if (r == 2 && c == 2) {
            System.out.println(p);
            return;
        }
        if (r == 1 && c == 1) {
            return;
        }
        if (r < 2) {
            mazePathWithObstacles(p + 'D', r + 1, c);
        }
        if (c < 2) {
            mazePathWithObstacles(p + 'R', r, c + 1);
        }

    }

    // PRINTS DIAGONAL ALSO
    static void mazePathWithObstaclesDiagonalAllowed(String p, int r, int c) {
        if (r == 3 && c == 3) {
            System.out.println(p);
            return;
        }
        if (r == c) {
            if (r != 1 && c != 1) {
                mazePathWithObstaclesDiagonalAllowed(p + "X", r + 1, c + 1);
            }
        }
        if (r < 3) {
            mazePathWithObstacles(p + 'D', r + 1, c);
        }
        if (c < 3) {
            mazePathWithObstacles(p + 'R', r, c + 1);
        }

    }

}
