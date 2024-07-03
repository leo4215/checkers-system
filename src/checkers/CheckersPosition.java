package checkers;

import boardgame.Position;

public class CheckersPosition extends Position {

    public CheckersPosition(int row, int column) {
        super(row, column);
    }

    public CheckersPiece getCheckersPiece() {
        return (CheckersPiece) super.getPiece();
    }
}
