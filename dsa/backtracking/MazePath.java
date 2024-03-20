package backtracking;

public class MazePath {
    public static void main(String[] args) {

        // mazePath("", 3, 3);

        mazePathDiagonalAllowed("", 3, 3);

        // int ans = mazePathCount(3, 3);
        // System.out.println(ans);
    }

    // PRINTS ALL PATHS TO REACH GOAL
    static void mazePath(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }

        if (r > 1) {
            mazePath(p + 'D', r - 1, c);
        }
        if (c > 1) {
            mazePath(p + 'R', r, c - 1);
        }

    }

    // PRINTS DIAGONAL ALSO
    static void mazePathDiagonalAllowed(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r == c) {
            mazePathDiagonalAllowed(p + "X", r - 1, c - 1);
        }
        if (r > 1) {
            mazePathDiagonalAllowed(p + 'D', r - 1, c);
        }
        if (c > 1) {
            mazePathDiagonalAllowed(p + 'R', r, c - 1);
        }

    }

    // RETURNS COUNT
    static int mazePathCount(int r, int c) {
        int count = 0;
        if (r == 1 || c == 1) {
            return 1;
        }
        count += mazePathCount(r - 1, c);
        count += mazePathCount(r, c - 1);

        return count;

    }

}
