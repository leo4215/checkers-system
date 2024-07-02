package checkers;

public class CheckersPiece {

    private Color color;
    private boolean isKing;

    public CheckersPiece(Color color) {
        this.color = color;
        this.isKing = false;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean isKing) {
        this.isKing = isKing;
    }

    @Override
    public String toString() {
        if (isKing) {
            return "K";
        }
        return this.color == Color.WHITE ? "W" : "B";
    }
}
