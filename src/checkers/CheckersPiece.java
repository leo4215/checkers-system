package checkers;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public class CheckersPiece extends Piece {

    private Color color;
    private boolean isKing;
    private CheckersMatch match;

    public CheckersPiece(Board board, Color color, CheckersMatch match) {
        super(board);
        this.color = color;
        this.isKing = false;
        this.match = match;
    }

    public Color getColor() {
        return color;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean isKing) {
        this.isKing = isKing;
    }

    private boolean isThereOpponentPiece(Position position) {
        CheckersPiece p = (CheckersPiece) getBoard().piece(position.getRow(), position.getColumn());
        return p != null && p.getColor() != color;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position sourcePos = getBoard().position(this);

        int[][] directions;
        if (isKing()) {
            directions = new int[][] { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
        } else if (getColor() == Color.WHITE) {
            directions = new int[][] { { -1, -1 }, { -1, 1 } };
        } else {
            directions = new int[][] { { 1, -1 }, { 1, 1 } };
        }

        boolean hasCapture = false;
        boolean[][] captureMoves = new boolean[getBoard().getRows()][getBoard().getColumns()];

        for (int[] direction : directions) {
            int row = sourcePos.getRow() + direction[0];
            int col = sourcePos.getColumn() + direction[1];

            if (getBoard().positionExists(row, col)) {
                Position simpleMoveTarget = getBoard().position(row, col);
                if (!getBoard().hasPiece(simpleMoveTarget) && !hasCapture) {
                    mat[row][col] = true;
                }

                int jumpRow = row + direction[0];
                int jumpCol = col + direction[1];
                if (getBoard().positionExists(jumpRow, jumpCol)) {
                    Position captureTarget = getBoard().position(jumpRow, jumpCol);
                    if (isThereOpponentPiece(simpleMoveTarget) && !getBoard().hasPiece(captureTarget)) {
                        hasCapture = true;
                        captureMoves[jumpRow][jumpCol] = true;
                        match.addCapturedPiece(simpleMoveTarget);
                    }
                }
            }
        }
        if (hasCapture) {
            return captureMoves;
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
