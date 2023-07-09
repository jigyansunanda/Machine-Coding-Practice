package DAO;

import Model.PieceType;
import Model.Player;

import java.util.HashMap;
import java.util.Map;

public class PieceInfo {
    private Map<PieceType, Player> pieceTypePlayerMap;

    public PieceInfo() {
        this.pieceTypePlayerMap = new HashMap<>();
    }

    public Map<PieceType, Player> getPieceTypePlayerMap() {
        return pieceTypePlayerMap;
    }

    public void setPieceTypePlayerMap(Map<PieceType, Player> pieceTypePlayerMap) {
        this.pieceTypePlayerMap = pieceTypePlayerMap;
    }
}
