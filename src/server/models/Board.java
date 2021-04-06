package server.models;

public class Board implements Constants {
    /**
     * Stores the state of the playing board tiles
     */
    private int[][] board;

    /**
     * Tracks number of tiles that contain non-empty values
     */
    private int occupiedCount;

    /**
     * Tracks if board has a win condition
     */
    private boolean hasWinner;

    public Board() {
        initializeEmptyBoard();
    }

    // Initializes a board filled with empty values
    protected void initializeEmptyBoard() {
        occupiedCount = 0;

        this.board = ArrayHelpers.createArr2DWithFillValue(BOARD_SIDE_LENGTH, BOARD_SIDE_LENGTH, EMPTY_TILE_NUM);
    }

    protected boolean isTileEmpty(int row, int col) {
        return board[row][col] == EMPTY_TILE_NUM;
    }

    protected void setNumAtTile(int num, int row, int col) {
        if (row < 0 || row >= BOARD_SIDE_LENGTH) {
            throw new IllegalArgumentException("Invalid row index");
        }
        if (col < 0 || col >= BOARD_SIDE_LENGTH) {
            throw new IllegalArgumentException("Invalid column index");
        }

        // If num equals empty tile number and not previously empty, then decrement occupied count
        if (num == EMPTY_TILE_NUM && board[row][col] != EMPTY_TILE_NUM) {
            this.occupiedCount--;
        }

        // If originally empty, increment occupied count
        if (num != EMPTY_TILE_NUM && board[row][col] == EMPTY_TILE_NUM) {
            this.occupiedCount++;
        }

        // If tile originally contained winning number and now setting tile to something else, update winner flag
        if (num != WINNING_NUM && board[row][col] == WINNING_NUM) {
            this.hasWinner = false;
        }

        // If num equals winning number, then update winner flag
        if (num == WINNING_NUM) {
            this.hasWinner = true;
        }

        // Set number at tile
        board[row][col] = num;
    }

    protected boolean checkWinner() {
        return hasWinner;
    }

    protected boolean checkLoser() {
        // Loser if board is fully occupied and no tiles contain the winning number
        return (occupiedCount == BOARD_SIDE_LENGTH * BOARD_SIDE_LENGTH) && !hasWinner;
    }

    public int[][] getBoardState() {
        return this.board;
    }

    public int getBoardValue(int row, int col) {
        return this.board[row][col];
    }

    public int getOccupiedCount() {
        return occupiedCount;
    }
}
