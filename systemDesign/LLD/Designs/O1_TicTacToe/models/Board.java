package systemDesign.LLD.Designs.O1_TicTacToe.models;

import java.util.*;

public class Board {

    public int size;
    public PlayerPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayerPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayerPiece playerPiece) {
        if (board[row][col] != null) {
            return false;
        }
        board[row][col] = playerPiece;
        return true;
    }

    public List<Map<Integer, Integer>> getFreeCells() {
        List<Map<Integer, Integer>> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    Map<Integer, Integer> coordinates = new HashMap<>();
                    coordinates.put(0, i);
                    coordinates.put(1, j);
                    list.add(coordinates);
                }
            }
        }

        return list;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
