package server.controllers;

import server.models.*;

public class ModelController {
    private Game game;
    private GameManager gameManager;

    public ModelController() {
        this.game = null;
        this.gameManager = null;
    }

    public void startGame() {
        // Set up board
        Board board = new Board();

        // Set up game manager and assign board
        gameManager = new GameManager();
        gameManager.setBoard(board);

        // Set up game
        this.game = new Game(board);

        // Start game
        gameManager.setUpGame();
    }

    public void clearGame() {
        this.game = null;
        this.gameManager = null;
    }

    public void restartGame() {
        clearGame();
        startGame();
    }

    /**
     * Asserts that game is in a valid state to be making a move
     */
    private void assertMovePossible() {
        if (gameManager == null || this.game == null) {
            throw new IllegalStateException("Game must first be created before making a move");
        }
        else if (game.hasLoser()) {
            throw new IllegalStateException("Cannot make a move since game was lost!");
        }
        else if (game.hasWinner()) {
            throw new IllegalStateException("Cannot make a move since game was won!");
        }
    }

    public void moveLeft() {
        assertMovePossible();

        LeftMove leftMove = new LeftMove();
        gameManager.performMove(leftMove);
    }

    public void moveRight() {
        assertMovePossible();

        RightMove rightMove = new RightMove();
        gameManager.performMove(rightMove);
    }

    public void moveUp() {
        assertMovePossible();

        UpMove upMove = new UpMove();
        gameManager.performMove(upMove);
    }

    public void moveDown() {
        assertMovePossible();

        DownMove downMove = new DownMove();
        gameManager.performMove(downMove);
    }

    public boolean hasWinner() {
        if (game == null) {
            throw new IllegalStateException("Game hasn't started!");
        }
        return game.hasWinner();
    }

    public boolean hasLoser() {
        if (game == null) {
            throw new IllegalStateException("Game hasn't started!");
        }

        return game.hasLoser();
    }

    public int[][] getBoardState() {
        if (game == null) {
            throw new IllegalStateException("Game hasn't started!");
        }

        return game.getBoardState();
    }
}
