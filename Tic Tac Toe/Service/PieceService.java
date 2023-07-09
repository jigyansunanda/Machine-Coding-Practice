package Service;

import Model.PieceType;

public class PieceService {
    public String getPiece(PieceType pieceType) {
        switch (pieceType) {
            case X:
                return "X";
            case O:
                return "O";
            default:
                return "-";
        }
    }
}
