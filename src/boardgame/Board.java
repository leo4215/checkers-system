package boardgame;

import checkers.CheckersPosition;

public class Board {

    private int rows;
    private int columns;
    private Position[][] mat;

    public Board() {
        this.rows = 8;
        this.columns = 8;
        this.mat = new Position[rows][columns]; // Instantiates the board Position matrix

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

    public Position position(int row, int column) { // Returns a matrix position by receiving the row and column numbers as a parameter
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return mat[row][column];
    }

    public Position position(Position position) { // Overloading: returns a matrix position by receiving a type Position as a parameter
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return mat[position.getRow()][position.getColumn()];
    }

    public Position position(Piece piece) { // Overloading: returns a matrix position by receiving a type Piece as a parameter
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (mat[i][j].getPiece() != null && mat[i][j].getPiece().equals(piece)) {
                    return mat[i][j];
                }
            }
        }
        return null;
    }

    public Piece piece(int row, int column) { // Returns a piece of a certain position of the matrix by receiving the row and column numbers as a parameter
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return mat[row][column].getPiece();
    }

    public void placePiece(Piece piece, Position position) { // Assigns the piece to the given matrix position
        position.setPiece(piece);
        mat[position.getRow()][position.getColumn()] = position;
    }

    public Piece removePiece(Position position) { // Removes a piece from a given position if it exists
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

    public boolean positionExists(int row, int column) { // Checks the existance of a position within the board by receiving the row and column numbers as a parameter
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) { // Overloading: checks the existance of a position within the board by receiving the type Position as a parameter 
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean hasPiece(Position position) { // Checks if a position contains a piece
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return position.getPiece() != null;
    }
}
