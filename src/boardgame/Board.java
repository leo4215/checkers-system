package boardgame;

public class Board {
    
    private int rows;
    private int columns;
    private Position[][] mat;

    public Board() {
        this.rows = 8;
        this.columns = 8;
        this.mat = new Position[rows][columns];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mat[i][j] = new Position(i, j);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}

