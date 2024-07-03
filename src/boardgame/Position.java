package boardgame;

public class Position {

    private int row;
    private int column;
    private Piece piece;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.piece = null;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    protected Piece getPiece() {
        return piece;
    }

    @Override
    public String toString() {
        return row + ", " + column;
    }
}
