enum Piece {
    RED, YELLOW
}

class Connect4 {
    private final int width;
    private final int height;
    private final Piece[][] board;
    private Piece turn = Piece.RED;
    private boolean gameOver = false;
    private Piece winner = null;

    Connect4(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new Piece[width][height];
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    void drop(Piece piece, int column) {
        for (int row = 0; row < height; row++) {
            if (board[column][row] == null) {
                board[column][row] = piece;
                break;
            }
        }
        turn = (turn == Piece.RED) ? Piece.YELLOW : Piece.RED;
    }

    Piece whoseTurn() {
        return turn;
    }

    Piece getPieceAt(int x, int y) {
        return board[x][y];
    }

    boolean isGameOver() {
        return gameOver;
    }

    Piece getWinner() {
        return winner;
    }
}