package checkers;

import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public class CheckersMatch {

    private Board board;
    private Color currentPlayer;
    private int turn;
    private int whiteCapturedPieces;
    private int blackCapturedPieces;

    private List<Position> capturedPiecesPos = new ArrayList<>();

    public CheckersMatch() {
        this.board = new Board();
        this.turn = 1;
        this.whiteCapturedPieces = 0;
        this.blackCapturedPieces = 0;
        this.currentPlayer = Color.WHITE;
        initialSetup();
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public int getTurn() {
        return turn;
    }

    public int getWhiteCapturedPieces() {
        return whiteCapturedPieces;
    }

    public int getBlackCapturedPieces() {
        return blackCapturedPieces;
    }

    public CheckersPosition[][] getPositions() { // Downcasting matrix of positions on the board from type Position to type CheckersPosition
        CheckersPosition[][] mat = new CheckersPosition[board.getRows()][board.getColumns()];

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (CheckersPosition) board.position(i, j);
            }
        }
        return mat;
    }

    public boolean[][] possibleMoves(CheckersPosition sourcePosition) {
        Position position = board.position(sourcePosition.toPosition());
        validateSourcePosition(position);
        return board.piece(position.getRow(), position.getColumn()).possibleMoves();
    }

    public void performCheckersMove(CheckersPosition sourcePosition, CheckersPosition targetPosition) { // Handles the game logic by executing a move from the source to the target position
        Position source = board.position(sourcePosition.toPosition());
        Position target = board.position(targetPosition.toPosition());
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        makeMove(source, target);
        nextTurn();
    }

    public void makeMove(Position source, Position target) { // Makes a move by placing a piece from source to target position and removing captured pieces
        if (board.hasPiece(target)) {
            throw new CheckersException("There already is a piece on target position");
        }

        Piece p = board.removePiece(source);
        board.placePiece(p, target);

        for (Position capturePos : capturedPiecesPos) {
            if (capturePos != null) {
                CheckersPiece capturedPiece = (CheckersPiece) board.piece(capturePos.getRow(), capturePos.getColumn());
                if (capturedPiece != null) {
                    if (capturedPiece.getColor() == Color.WHITE) {
                        whiteCapturedPieces++;
                    } else if (capturedPiece.getColor() == Color.BLACK) {
                        blackCapturedPieces++;
                    }
                    board.removePiece(capturePos);
                }
            }
        }
        capturedPiecesPos.clear();
    }

    protected void addCapturedPiece(Position position) {
        capturedPiecesPos.add(position);
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void validateSourcePosition(Position position) { // Validates the source position, ensuring there is a piece at the source and that it has possible moves
        if (!board.hasPiece(position)) {
            throw new CheckersException("There is no piece on source position");
        }
        if (currentPlayer != ((CheckersPiece) board.piece(position.getRow(), position.getColumn())).getColor()) {
            throw new CheckersException("The chosen piece is not yours");
        }
        if (!board.piece(position.getRow(), position.getColumn()).isThereAnyPossibleMove()) {
            throw new CheckersException("There is no possible move for the chosen piece");
        }
    }

    private void validateTargetPosition(Position source, Position target) { // Validates the target position by ensuring it is a valid move from the source position
        if (!board.piece(source.getRow(), source.getColumn()).possibleMove(target)) {
            throw new CheckersException("The chosen piece can't move to target position");
        }
    }

    public void placeNewPiece(int row, char column, CheckersPiece piece) {
        board.placePiece(piece, new CheckersPosition(row, column));
    }

    public void initialSetup() { // Sets up the initial board configuration
        placeNewPiece(8, 'a', new CheckersPiece(board, Color.WHITE, this));
        placeNewPiece(8, 'c', new CheckersPiece(board, Color.WHITE, this));
        placeNewPiece(8, 'e', new CheckersPiece(board, Color.WHITE, this));
        placeNewPiece(8, 'g', new CheckersPiece(board, Color.WHITE, this));
        placeNewPiece(7, 'b', new CheckersPiece(board, Color.WHITE, this));
        placeNewPiece(7, 'd', new CheckersPiece(board, Color.WHITE, this));
        placeNewPiece(7, 'f', new CheckersPiece(board, Color.WHITE, this));
        placeNewPiece(7, 'h', new CheckersPiece(board, Color.WHITE, this));
        placeNewPiece(6, 'a', new CheckersPiece(board, Color.WHITE, this));
        placeNewPiece(6, 'c', new CheckersPiece(board, Color.WHITE, this));
        placeNewPiece(6, 'e', new CheckersPiece(board, Color.WHITE, this));
        placeNewPiece(6, 'g', new CheckersPiece(board, Color.WHITE, this));

        placeNewPiece(1, 'b', new CheckersPiece(board, Color.BLACK, this));
        placeNewPiece(1, 'd', new CheckersPiece(board, Color.BLACK, this));
        placeNewPiece(1, 'f', new CheckersPiece(board, Color.BLACK, this));
        placeNewPiece(1, 'h', new CheckersPiece(board, Color.BLACK, this));
        placeNewPiece(2, 'a', new CheckersPiece(board, Color.BLACK, this));
        placeNewPiece(2, 'c', new CheckersPiece(board, Color.BLACK, this));
        placeNewPiece(2, 'e', new CheckersPiece(board, Color.BLACK, this));
        placeNewPiece(2, 'g', new CheckersPiece(board, Color.BLACK, this));
        placeNewPiece(3, 'b', new CheckersPiece(board, Color.BLACK, this));
        placeNewPiece(3, 'd', new CheckersPiece(board, Color.BLACK, this));
        placeNewPiece(3, 'f', new CheckersPiece(board, Color.BLACK, this));
        placeNewPiece(3, 'h', new CheckersPiece(board, Color.BLACK, this));
    }
}
