package systemDesign.LLD.Designs.O1_TicTacToe.models;

public class Player {

    public String name;
    public PlayerPiece playerPiece;

    public Player(String name, PlayerPiece playerPiece) {
        this.name = name;
        this.playerPiece = playerPiece;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerPiece getPlayerPiece() {
        return this.playerPiece;
    }

    public void setPlayerPiece(PlayerPiece piece) {
        this.playerPiece = piece;
    }
}
