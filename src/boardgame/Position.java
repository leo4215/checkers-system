package boardgame;

public class Position {

    private int row;
    private int column;
    protected Piece piece;

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

    protected Piece getPiece() { // Returns a Piece located at this position. Accessed only within the board layer. 
        return piece;
    }

    protected void setPiece(Piece piece) { // Sets a Piece at this position. Accessed only within the board layer.
        this.piece = piece;
    }

    public void setValues(int row, int column) { // Sets new row and column values to a position. 
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return row + ", " + column;
    }
}
