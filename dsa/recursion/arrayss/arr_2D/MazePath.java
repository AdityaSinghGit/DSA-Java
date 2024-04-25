package recursion.arrayss.arr_2D;

public class MazePath {
    public static void main(String[] args) {
        int ans = mazeCountPath(3, 3);

        System.out.println(ans);

        mazePath("", 3, 3);

        mazePathDiagonalAllowed("", 3, 3);

    }

    // TIME : O(2 ^ (m*n))
    // SPACE : O((m-1) + (n-1))

    // RETURNS COUNT
    static int mazeCountPath(int r, int c) {
        int count = 0;
        if (r == 1 || c == 1) {
            return 1;
        }
        count += mazeCountPath(r - 1, c);
        count += mazeCountPath(r, c - 1);

        return count;

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

}
