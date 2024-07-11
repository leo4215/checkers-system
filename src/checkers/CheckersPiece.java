package checkers;

import boardgame.Board;
import boardgame.Piece;

public class CheckersPiece extends Piece {

    private Color color;
    private boolean isKing;

    public CheckersPiece(Board board, Color color) {
        super(board);
        this.color = color;
        this.isKing = false;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean isKing) {
        this.isKing = isKing;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }

    @Override
    public String toString() {
        if (isKing) {
            return "K";
        }
        return this.color == Color.WHITE ? "W" : "B";
    }
}
