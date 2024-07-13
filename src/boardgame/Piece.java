package boardgame;

public abstract class Piece {

    private Board board;

    public Piece(Board board) {
        this.board = board;
    }

    protected Board getBoard() { // The board should only be accessed within the board layer, not in the checkers layer
        return board;
    }

    public abstract boolean[][] possibleMoves();  // Abstract method that returns a matrix of possible moves for the piece

    public boolean possibleMove(Position position) { //HookMethod: checks if the piece can move to the given position
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() { // Checks if there is at least one possible movement for a piece
        boolean[][] mat = possibleMoves();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
