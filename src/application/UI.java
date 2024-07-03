package application;

import checkers.CheckersPosition;

public class UI {
    
    public static void printBoard(CheckersPosition[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < mat.length; j++) {
                System.out.print(printPosition(mat[i][j]));
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    public static String printPosition(CheckersPosition position) {
        if (position.getCheckersPiece() == null) {
            return " -";
        } else {
            return " " + position.getCheckersPiece();
        }
    }
}
