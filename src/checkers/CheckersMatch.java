package checkers;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

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

    public void performCheckersMove(CheckersPosition sourcePosition, CheckersPosition targetPosition) {
        Position source = board.position(sourcePosition.toPosition());
        Position target = board.position(targetPosition.toPosition());
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        makeMove(source, target);
    }

    public void makeMove(Position source, Position target) {
        if (board.hasPiece(target)) {
            throw new CheckersException("There already is a piece on target position");    
        }
        Piece p = board.removePiece(source);
        board.placePiece(p, target);
    }

    private void validateSourcePosition(Position position) {
        if (!board.hasPiece(position)) {
            throw new CheckersException("There is no piece on source position.");
        }
        if (!board.piece(position.getRow(), position.getColumn()).isThereAnyPossibleMove()) {
            throw new CheckersException("There is no possible move for the chosen piece.");
        }
    }

    private void validateTargetPosition(Position source, Position target) {
        if (!board.piece(source.getRow(), source.getColumn()).possibleMove(target)) {
            throw new CheckersException("The chosen piece can't move to target position");
        }
    }

    public void placeNewPiece(int row, char column, CheckersPiece piece) {
        board.placePiece(piece, new CheckersPosition(row, column));
    }

    public void initialSetup() {
        placeNewPiece(8, 'a', new CheckersPiece(board, Color.WHITE));
        placeNewPiece(8, 'c', new CheckersPiece(board, Color.WHITE));
        placeNewPiece(8, 'e', new CheckersPiece(board, Color.WHITE));
        placeNewPiece(8, 'g', new CheckersPiece(board, Color.WHITE));
        placeNewPiece(7, 'b', new CheckersPiece(board, Color.WHITE));
        placeNewPiece(7, 'd', new CheckersPiece(board, Color.WHITE));
        placeNewPiece(7, 'f', new CheckersPiece(board, Color.WHITE));
        placeNewPiece(7, 'h', new CheckersPiece(board, Color.WHITE));
        placeNewPiece(6, 'a', new CheckersPiece(board, Color.WHITE));
        placeNewPiece(6, 'c', new CheckersPiece(board, Color.WHITE));
        placeNewPiece(6, 'e', new CheckersPiece(board, Color.WHITE));
        placeNewPiece(6, 'g', new CheckersPiece(board, Color.WHITE));

        placeNewPiece(1, 'b', new CheckersPiece(board, Color.BLACK));
        placeNewPiece(1, 'd', new CheckersPiece(board, Color.BLACK));
        placeNewPiece(1, 'f', new CheckersPiece(board, Color.BLACK));
        placeNewPiece(1, 'h', new CheckersPiece(board, Color.BLACK));
        placeNewPiece(2, 'a', new CheckersPiece(board, Color.BLACK));
        placeNewPiece(2, 'c', new CheckersPiece(board, Color.BLACK));
        placeNewPiece(2, 'e', new CheckersPiece(board, Color.BLACK));
        placeNewPiece(2, 'g', new CheckersPiece(board, Color.BLACK));
        placeNewPiece(3, 'b', new CheckersPiece(board, Color.BLACK));
        placeNewPiece(3, 'd', new CheckersPiece(board, Color.BLACK));
        placeNewPiece(3, 'f', new CheckersPiece(board, Color.BLACK));
        placeNewPiece(3, 'h', new CheckersPiece(board, Color.BLACK));
    }
}
