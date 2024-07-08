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

    public void initialSetup() {
        board.placePiece(new CheckersPiece(Color.WHITE), new CheckersPosition(7, 0));
        board.placePiece(new CheckersPiece(Color.WHITE), new CheckersPosition(7, 2));
        board.placePiece(new CheckersPiece(Color.WHITE), new CheckersPosition(7, 4));
        board.placePiece(new CheckersPiece(Color.WHITE), new CheckersPosition(7, 6));
        board.placePiece(new CheckersPiece(Color.WHITE), new CheckersPosition(6, 1));
        board.placePiece(new CheckersPiece(Color.WHITE), new CheckersPosition(6, 3));
        board.placePiece(new CheckersPiece(Color.WHITE), new CheckersPosition(6, 5));
        board.placePiece(new CheckersPiece(Color.WHITE), new CheckersPosition(6, 7));
        board.placePiece(new CheckersPiece(Color.WHITE), new CheckersPosition(5, 0));
        board.placePiece(new CheckersPiece(Color.WHITE), new CheckersPosition(5, 2));
        board.placePiece(new CheckersPiece(Color.WHITE), new CheckersPosition(5, 4));
        board.placePiece(new CheckersPiece(Color.WHITE), new CheckersPosition(5, 6));
        board.placePiece(new CheckersPiece(Color.BLACK), new CheckersPosition(0, 1));
        board.placePiece(new CheckersPiece(Color.BLACK), new CheckersPosition(0, 3));
        board.placePiece(new CheckersPiece(Color.BLACK), new CheckersPosition(0, 5));
        board.placePiece(new CheckersPiece(Color.BLACK), new CheckersPosition(0, 7));
        board.placePiece(new CheckersPiece(Color.BLACK), new CheckersPosition(1, 0));
        board.placePiece(new CheckersPiece(Color.BLACK), new CheckersPosition(1, 2));
        board.placePiece(new CheckersPiece(Color.BLACK), new CheckersPosition(1, 4));
        board.placePiece(new CheckersPiece(Color.BLACK), new CheckersPosition(1, 6));
        board.placePiece(new CheckersPiece(Color.BLACK), new CheckersPosition(2, 1));
        board.placePiece(new CheckersPiece(Color.BLACK), new CheckersPosition(2, 3));
        board.placePiece(new CheckersPiece(Color.BLACK), new CheckersPosition(2, 5));
        board.placePiece(new CheckersPiece(Color.BLACK), new CheckersPosition(2, 7));
    }

}
