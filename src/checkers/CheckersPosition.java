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

    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    protected static CheckersPosition fromPosition(Position position) {
        return new CheckersPosition(8 - position.getRow(), (char)('a' - position.getColumn()));
    }

    @Override
    public String toString() {
        return "" + row + column;
    }
}
