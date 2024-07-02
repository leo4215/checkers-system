package boardgame;

public abstract class Piece { 
    
    private Board board;

    public Piece() {
    }
    
    protected Board getBoard() {
        return board;
    }
}
