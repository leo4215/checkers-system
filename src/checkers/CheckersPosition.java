package checkers;

import boardgame.Position;

public class CheckersPosition extends Position {
    
    private int row;
    private char column;

    public CheckersPosition(int row, char column) {
        super(row - 1, column - 'a');
        if (row < 1 || row > 8 || column < 'a' || column > 'h') {
            throw new CheckersException("Error instantiating CheckersPosition. Valid values are from 1a to 8h");
        }
        this.row = row;
        this.column = column;
    }

    public CheckersPiece getCheckersPiece() {
        return (CheckersPiece) super.getPiece();
    }

    @Override
    public String toString() {
        return "" + row + column;
    }
}
