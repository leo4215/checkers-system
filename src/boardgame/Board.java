package boardgame;

import checkers.CheckersException;
import checkers.CheckersPosition;

public class Board {

    private int rows;
    private int columns;
    private Position[][] mat;

    public Board() {
        this.rows = 8;
        this.columns = 8;
        this.mat = new Position[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char column = (char) ('a' + j); // Converts the column index (j) to the corresponding letter
                mat[i][j] = new CheckersPosition(i + 1, column);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Position position(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return mat[row][column];
    }

    public Position position(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return mat[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        position.setPiece(piece);
        mat[position.getRow()][position.getColumn()] = position;
    }

    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        if (position.getPiece() == null) {
            return null;
        }

        Piece p = mat[position.getRow()][position.getColumn()].getPiece();
        mat[position.getRow()][position.getColumn()].setPiece(null);
        return p;
    }

    public boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean hasPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return position.getPiece() != null;
    }
}
