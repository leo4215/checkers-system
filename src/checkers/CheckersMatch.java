package checkers;

import boardgame.Board;
import boardgame.Position;

public class CheckersMatch {

    private Board board;
    private Color currentPlayer;
    private int turn;

    public CheckersMatch() {
        this.board = new Board();
        this.turn = 0;
        this.currentPlayer = Color.WHITE;
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
                // mat[i][j] = (CheckersPosition) board.position(i, j);
                Position pos = board.position(i, j);
                mat[i][j] = new CheckersPosition(pos.getRow(), pos.getColumn());
            }
        }
        return mat;
    }
}
