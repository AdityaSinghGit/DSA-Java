package patterns;

public class UpsideDownHalfTriangle {
    public static void main(String[] args) {
        printUpsideDownHalfTriangle(5, 0);
    }

    public static void printUpsideDownHalfTriangle(int row, int col) {
        if (col < row) {
            System.out.print("* ");
            printUpsideDownHalfTriangle(row, col + 1);
        } else if (col == row) {
            System.out.println();
            printUpsideDownHalfTriangle(row - 1, 0);
        } else {
            return;
        }

    }
}
