package Service;

import DAO.PieceInfo;
import Model.Piece;
import Model.PieceType;
import Model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private int playerCount;
    private List<Player> players;
    private PieceInfo pieceInfo;
    private PieceService pieceService;
    private int currentPlayerIndex;

    public PlayerService(int playerCount) {
        this.playerCount = playerCount;
        this.players = new ArrayList<>();
        this.pieceInfo = new PieceInfo();
        this.pieceService = new PieceService();
        this.currentPlayerIndex = 0;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    // check whether piece already exists or not
    public boolean isPieceOccupied(PieceType pieceType) {
        if (pieceInfo.getPieceTypePlayerMap().containsKey(pieceType)) {
            Player pieceHoldingPlayer = pieceInfo.getPieceTypePlayerMap().get(pieceType);
            String playerName = pieceHoldingPlayer.getName();
            System.out.println(playerName + " is using " + pieceService.getPiece(pieceType));
            return true;
        }
        return false;
    }

    // adds new player with their chosen piece
    public boolean addPlayer(PieceType pieceType, String name) {
        if (!isPieceOccupied(pieceType)) {
            Piece piece = new Piece(pieceType);
            Player player = new Player(name, piece);
            players.add(player);
            pieceInfo.getPieceTypePlayerMap().put(pieceType, player);
            return true;
        }
        return false;
    }

    // gets the player who has the current turn
    public Player getCurrentTurnPlayer() {
        return players.get(currentPlayerIndex);
    }

    // get the player who had the last turn
    public Player getLastTurnPlayer() {
        int lastPlayerIndex = (currentPlayerIndex - 1 + playerCount) % playerCount;
        return players.get(lastPlayerIndex);
    }

    // move current player index
    protected void setNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % playerCount;
    }
}
