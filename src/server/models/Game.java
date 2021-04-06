package server.models;

/**
 * This class acts as the observable state of the game
 */
public class Game {
    private Board board;

    public Game(Board board) {
        setBoard(board);
    }

    protected Board getBoard() {
        return board;
    }

    public int[][] getBoardState() {
        return board.getBoardState();
    }

    public boolean hasWinner() {
        if (board == null) {
            throw new IllegalStateException("Game isn't attached to a board");
        }

        return board.checkWinner();
    }

    public boolean hasLoser() {
        if (board == null) {
            throw new IllegalStateException("Game isn't attached to a board");
        }

        return board.checkLoser();
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
