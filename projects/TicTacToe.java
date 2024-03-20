package projects;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            showBoard(board);
            System.out.println("Player " + player + " enter : ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player; // place the element
                gameOver = haveWon(board, player);
                if (!gameOver) {
                    player = player == 'X' ? 'O' : 'X';
                } else {
                    System.out.println("Player " + player + " has won!!");
                }
            } else {
                System.out.println("Invalid move, try again!!");
            }
        }
        showBoard(board);
        scanner.close();
    }

    private static boolean haveWon(char[][] board, char player) {
        // check rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        // check cols
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // check LTR diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        // check RTL diagonal
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    private static void showBoard(char[][] board) {
        for (char[] row : board) {
            for (char element : row) {
                if (element != ' ') {
                    System.out.print(element + " | ");
                } else {
                    System.out.print("  | ");
                }
            }
            System.out.println();
        }
    }
}
