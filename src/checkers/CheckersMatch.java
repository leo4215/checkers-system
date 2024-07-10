package checkers;

import boardgame.Board;

public class CheckersMatch {

    private Board board;
    private Color currentPlayer;
    private int turn;

    public CheckersMatch() {
        this.board = new Board();
        this.turn = 0;
        this.currentPlayer = Color.WHITE;
        initialSetup();
    }

    public Board getBoard() {
        return board;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public int getTurn() {
        return turn;
    }

    public CheckersPosition[][] getPositions() {
        CheckersPosition[][] mat = new CheckersPosition[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (CheckersPosition) board.position(i, j);
            }
        }
        return mat;
    }

    public void placeNewPiece(int row, char column, CheckersPiece piece) {
        board.placePiece(piece, new CheckersPosition(row, column));
    }

    public void initialSetup() {
        placeNewPiece(8, 'a', new CheckersPiece(Color.WHITE));
        placeNewPiece(8, 'c', new CheckersPiece(Color.WHITE));
        placeNewPiece(8, 'e', new CheckersPiece(Color.WHITE));
        placeNewPiece(8, 'g', new CheckersPiece(Color.WHITE));
        placeNewPiece(7, 'b', new CheckersPiece(Color.WHITE));
        placeNewPiece(7, 'd', new CheckersPiece(Color.WHITE));
        placeNewPiece(7, 'f', new CheckersPiece(Color.WHITE));
        placeNewPiece(7, 'h', new CheckersPiece(Color.WHITE));
        placeNewPiece(6, 'a', new CheckersPiece(Color.WHITE));
        placeNewPiece(6, 'c', new CheckersPiece(Color.WHITE));
        placeNewPiece(6, 'e', new CheckersPiece(Color.WHITE));
        placeNewPiece(6, 'g', new CheckersPiece(Color.WHITE));

        placeNewPiece(1, 'b', new CheckersPiece(Color.BLACK));
        placeNewPiece(1, 'd', new CheckersPiece(Color.BLACK));
        placeNewPiece(1, 'f', new CheckersPiece(Color.BLACK));
        placeNewPiece(1, 'h', new CheckersPiece(Color.BLACK));
        placeNewPiece(2, 'a', new CheckersPiece(Color.BLACK));
        placeNewPiece(2, 'c', new CheckersPiece(Color.BLACK));
        placeNewPiece(2, 'e', new CheckersPiece(Color.BLACK));
        placeNewPiece(2, 'g', new CheckersPiece(Color.BLACK));
        placeNewPiece(3, 'b', new CheckersPiece(Color.BLACK));
        placeNewPiece(3, 'd', new CheckersPiece(Color.BLACK));
        placeNewPiece(3, 'f', new CheckersPiece(Color.BLACK));
        placeNewPiece(3, 'h', new CheckersPiece(Color.BLACK));
    }

}
