package systemDesign.LLD.Designs.O1_TicTacToe;

import java.util.*;

import systemDesign.LLD.Designs.O1_TicTacToe.models.Board;
import systemDesign.LLD.Designs.O1_TicTacToe.models.PieceO;
import systemDesign.LLD.Designs.O1_TicTacToe.models.PieceType;
import systemDesign.LLD.Designs.O1_TicTacToe.models.PieceX;
import systemDesign.LLD.Designs.O1_TicTacToe.models.Player;

public class Game {

    Deque<Player> players;
    Board board;

    Game() {
        initializeGame();
    }

    public void initializeGame() {
        players = new LinkedList<>();

        PieceX cross = new PieceX();
        Player playerX = new Player("PlayerX", cross);

        PieceO zero = new PieceO();
        Player playerO = new Player("PlayerO", zero);

        players.add(playerX);
        players.add(playerO);

        board = new Board(3);
    }

    public String startGame() {

        boolean isWinner = false;
        while (!isWinner) {

            Player playerTurn = players.removeFirst();

            board.printBoard();
            List<Map<Integer, Integer>> freeCells = board.getFreeCells();
            if (freeCells.isEmpty()) {
                isWinner = true;
                continue;
            }

            System.out.println(playerTurn.name + " enter row,col : ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] rowCol = s.split(",");
            int row = Integer.valueOf(rowCol[0]);
            int col = Integer.valueOf(rowCol[1]);

            if (row > board.size || col > board.size) {
                System.out.println("Invalid move, the coordinate does not exist");
                players.addFirst(playerTurn);
                continue;
            }

            boolean success = board.addPiece(row, col, playerTurn.playerPiece);
            if (!success) {
                System.out.println("The cell is taken, please enter new coordinates.");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean isVictory = victory(row, col, playerTurn.playerPiece.pieceType);
            if (isVictory) {
                isWinner = true;
                inputScanner.close();
                return playerTurn.name + " has won the match!";
            }

        }

        return "It's a tie!";

    }

    public boolean victory(int row, int col, PieceType pieceType) {
        boolean isRow = true;
        boolean isCol = true;
        boolean isFDiag = true;
        boolean isBDiag = true;

        for (int i = 0; i < board.size; i++) {
            if (board.board[row][i] == null || board.board[row][i].pieceType != pieceType) {
                isRow = false;
            }
        }
        for (int i = 0; i < board.size; i++) {
            if (board.board[i][col] == null || board.board[i][col].pieceType != pieceType) {
                isCol = false;
            }
        }
        for (int i = 0; i < board.size; i++) {
            if (board.board[i][i] == null || board.board[i][i].pieceType != pieceType) {
                isFDiag = false;
            }
        }
        for (int i = 0, j = board.size - 1; i < board.size; i++, j--) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                isBDiag = false;
            }
        }

        return isRow || isCol || isFDiag || isBDiag;
    }
}
