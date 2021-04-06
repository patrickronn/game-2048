package server.models;

/**
 * Manages the game state and acts as a validator for changes made to the game state.
 */
public class GameManager implements Constants {
    private Board board;

    public GameManager() {
        setBoard(null);
    }

    /**
     * Starts a game and randomly places tiles.
     */
    public void setUpGame() {
        if (board == null) {
            throw new IllegalArgumentException("Board and player must be assigned before starting a game");
        }

        // Add random tiles to start off the game
        for (int i = 0; i < RANDOM_TILES_AT_START; i++) {
            int numToAdd = RandomGenerator.chooseBetweenTwoNums(RANDOM_TILE_NUM1, RANDOM_TILE_NUM2, RANDOM_TILE_NUM1_PROB);
            addRandomNumToRandomTile(numToAdd);
        }
    }

    /**
     * Helper method to find a random, empty tile then places the specified number.
     * @param numToAdd number to add to empty tile
     */
    private void addRandomNumToRandomTile(int numToAdd) {
        if (this.board.getOccupiedCount() == (BOARD_SIDE_LENGTH * BOARD_SIDE_LENGTH)) {
            throw new IllegalStateException("Cannot add tile to a full board!");
        }

        int rowToAdd = -1;
        int colToAdd = -1;

        // Find an empty tile
        while (rowToAdd < 0 && colToAdd < 0) {
            int randomRow = RandomGenerator.getRandomInt(0, BOARD_SIDE_LENGTH - 1);
            int randomCol = RandomGenerator.getRandomInt(0, BOARD_SIDE_LENGTH - 1);

            if (this.board.isTileEmpty(randomRow, randomCol)) {
                rowToAdd = randomRow;
                colToAdd = randomCol;
            }
        }

        // Add to board
        this.board.setNumAtTile(numToAdd, rowToAdd, colToAdd);
    }

    /**
     * Performs the move on the current board state then updates the board
     * @param move a move to perform on the game board
     */
    public void performMove(Move move) {
        if (board.checkWinner() || board.checkLoser()) {
            throw new IllegalStateException("Cannot perform move when game is over!");
        }

        // Determine updated state after making a move
        int[][] updatedBoardState = move.makeMove(this.board.getBoardState());

        // Update board
        int numTilesUpdate = updateBoard(updatedBoardState);

        // If at least one tile was updated and game isn't over, place a random tile
        if ( (numTilesUpdate > 0) && !board.checkWinner() && !board.checkLoser()) {
            int numToAdd = RandomGenerator.chooseBetweenTwoNums(RANDOM_TILE_NUM1, RANDOM_TILE_NUM2, RANDOM_TILE_NUM1_PROB);
            addRandomNumToRandomTile(numToAdd);
        }
    }

    /**
     * Updates the state of the board with a newly specified state, one tile at a time
     * @param updatedBoardState new state of the board
     * @return number of tiles that changed values since previous state
     */
    private int updateBoard(int[][] updatedBoardState) {
        int numTilesUpdated = 0;

        for (int i = 0; i < updatedBoardState.length; i++) {
            for (int j = 0; j < updatedBoardState.length; j++) {
                int updatedNum = updatedBoardState[i][j];

                // Only update if tile changed its value
                if (updatedNum != board.getBoardValue(i, j)) {
                    board.setNumAtTile(updatedNum, i, j);
                    numTilesUpdated++;
                }
            }
        }

        return numTilesUpdated;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
