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
            return mat[row][column];
        }

        public Position position(Position position) {
            return mat[position.getRow()][position.getColumn()];
        }

        public void placePiece(Piece piece, Position position) {
            position.setPiece(piece);
            mat[position.getRow()][position.getColumn()] = position;
        }
    }
