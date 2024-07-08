package boardgame;

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
                mat[i][j] = new CheckersPosition(i, j);
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
