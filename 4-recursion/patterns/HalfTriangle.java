package patterns;

public class HalfTriangle {
    public static void main(String[] args) {
        printHalfTriangle(5, 0);
    }

    // [NOTE] : In this case we are printing when the stack starts to pop
    // Therefore, printing the reverse pattern of :-
    // E:\Java\4-recursion\patterns\UpsideDownHalfTriangle.java
    public static void printHalfTriangle(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            printHalfTriangle(row, col + 1);
            System.out.print("* ");
        } else if (col == row) {
            printHalfTriangle(row - 1, 0);
            System.out.println();
        }

    }
}
