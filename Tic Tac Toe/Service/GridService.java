package Service;

import Model.Grid;
import Model.Piece;
import Model.PieceType;
import Model.Player;

public class GridService {
    private int gridSize;
    private Grid grid;
    private PieceService pieceService;

    public GridService(int gridSize) {
        this.gridSize = gridSize;
        this.grid = new Grid(gridSize);
        this.pieceService = new PieceService();
    }

    // prints the current state of grid
    protected void printGrid() {
        for (int row= 0; row < this.gridSize; ++row) {
            for (int col = 0; col < this.gridSize; ++col) {
                Piece currentPiece = this.grid.getBoard()[row][col];
                if (currentPiece != null) {
                    System.out.print(pieceService.getPiece(currentPiece.getPieceType()) + " ");
                }
                else {
                    System.out.print("-" + " ");
                }
            }
            System.out.println();
        }
    }

    // check whether a move in the cell is valid or not
    protected boolean isValidMove(int row, int col) {
        Piece currentPiece = this.grid.getBoard()[row][col];
        return (currentPiece == null);
    }

    // check whether the piece is present in all column of current row
    protected boolean allColumnPiece(PieceType pieceType, int row) {
        for (int col = 0; col < this.gridSize; ++col) {
            if (this.grid.getBoard()[row][col] == null || pieceType != this.grid.getBoard()[row][col].getPieceType()) {
                return false;
            }
        }
        return true;
    }

    // check whether the piece is present in all row of current column
    protected boolean allRowPiece(PieceType pieceType, int col) {
        for (int row = 0; row < this.gridSize; ++row) {
            if (this.grid.getBoard()[row][col] == null || pieceType != this.grid.getBoard()[row][col].getPieceType()) {
                return false;
            }
        }
        return true;
    }

    // check whether the piece is present on the entire diagonal
    private boolean allDiagonalPiece(PieceType pieceType) {
        for (int row = 0; row < this.gridSize; ++row) {
            if (this.grid.getBoard()[row][row] == null || pieceType != this.grid.getBoard()[row][row].getPieceType()) {
                return false;
            }
        }
        return true;
    }

    // check whether the piece is present on the entire anti-diagonal
    private boolean allAntiDiagonalPiece(PieceType pieceType) {
        for (int row = 0; row < this.gridSize; ++row) {
            if (this.grid.getBoard()[row][this.gridSize-1-row] == null || pieceType != this.grid.getBoard()[row][this.gridSize-1-row].getPieceType()) {
                return false;
            }
        }
        return true;
    }

    protected boolean makeMove(Player player, int row, int col) {
        this.grid.getBoard()[row][col] = player.getPiece();
        if (allColumnPiece(player.getPiece().getPieceType(), row)) return true;
        if (allRowPiece(player.getPiece().getPieceType(), col)) return true;
        if (row == col && allDiagonalPiece(player.getPiece().getPieceType())) return true;
        if (row + col == (this.gridSize - 1) && allAntiDiagonalPiece(player.getPiece().getPieceType())) return true;
        return false;
    }
}
