package server.controllers;


public class ServerController {

    private ModelController modelController;

    public ServerController() {
        modelController = new ModelController();
    }

    public String startGame() {
        try {
            modelController.startGame();
            return "Server started a game. Please make a move";
        }
        catch (Exception e) {
            return "Error occurred when starting game: " + e.getMessage();
        }
    }

    public String stopGame() {
        try {
            modelController.clearGame();
            return "Server ended the game.";
        }
        catch (Exception e) {
            return "Error occurred when stopping game: " + e.getMessage();
        }
    }

    public String restartGame() {
        try {
            modelController.restartGame();
            return "Server restarted a game. Please make a move";
        }
        catch (Exception e) {
            return "Error occurred when restarting game: " + e.getMessage();
        }
    }

    public int[][] retrieveBoardState() {
        return modelController.getBoardState();
    }

    public boolean checkIsGameOver() {
        try {
            return modelController.hasWinner() || modelController.hasLoser();
        }
        catch (Exception e) {
            System.out.println("Error occurred: " + e);
            return false;
        }
    }

    public boolean checkWinCondition() {
        try {
            return modelController.hasWinner();
        }
        catch (Exception e) {
            System.out.println("Error occurred: " + e);
            return false;
        }
    }

    public boolean checkLoseCondition() {
        try {
            return modelController.hasLoser();
        }
        catch (Exception e) {
            System.out.println("Error occurred: " + e);
            return false;
        }
    }

    public String moveUp() {
        try {
            modelController.moveUp();
            return "Move up was successful";
        }
        catch (Exception e) {
            return "Error occurred when making move: " + e.getMessage();
        }
    }

    public String moveRight() {
        try {
            modelController.moveRight();
            return "Move right was successful";
        }
        catch (Exception e) {
            return "Error occurred when making move: " + e.getMessage();
        }
    }

    public String moveDown() {
        try {
            modelController.moveDown();
            return "Move down was successful";
        }
        catch (Exception e) {
            return "Error occurred when making move: " + e.getMessage();
        }
    }

    public String moveLeft() {
        try {
            modelController.moveLeft();
            return "Move left was successful";
        }
        catch (Exception e) {
            return "Error occurred when making move: " + e.getMessage();
        }
    }
}
