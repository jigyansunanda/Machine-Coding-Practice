package Model;

public class Grid {
    private int size;
    private Piece[][] board;

    public Grid(int size) {
        this.size = size;
        this.board = new Piece[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }
}
