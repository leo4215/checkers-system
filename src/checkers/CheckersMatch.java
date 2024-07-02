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
    }
    