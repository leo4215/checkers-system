package checkers;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

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

    // private boolean isThereOpponentPiece(Position position) {
    //     CheckersPiece p = (CheckersPiece) getBoard().piece(position.getRow(), position.getColumn());
    //     return p != null && p.getColor() != color;
    // }

    @Override
    public boolean[][] possibleMoves() { // Determines the possible moves for this piece
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        if (isKing()) {
            p.setValues(getBoard().position(this).getRow() - 1, getBoard().position(this).getColumn() - 1);
            if (getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(getBoard().position(this).getRow() - 1, getBoard().position(this).getColumn() + 1);
            if (getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(getBoard().position(this).getRow() + 1, getBoard().position(this).getColumn() - 1);
            if (getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(getBoard().position(this).getRow() + 1, getBoard().position(this).getColumn() + 1);
            if (getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            if (getColor() == Color.WHITE) {
                p.setValues(getBoard().position(this).getRow() - 1, getBoard().position(this).getColumn() - 1);
                if (getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
                p.setValues(getBoard().position(this).getRow() - 1, getBoard().position(this).getColumn() + 1);
                if (getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
            } else {
                p.setValues(getBoard().position(this).getRow() + 1, getBoard().position(this).getColumn() - 1);
                if (getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
                p.setValues(getBoard().position(this).getRow() + 1, getBoard().position(this).getColumn() + 1);
                if (getBoard().positionExists(p) && !getBoard().hasPiece(p)) {
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }
        }
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
