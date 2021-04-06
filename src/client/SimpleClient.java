package client;

import server.controllers.ServerController;

import java.util.Scanner;

public class SimpleClient {
    private ServerController serverController;

    final static int EMPTY_TILE_NUM = 0;

    public SimpleClient() {
    }

    public void playGame() {
        if (serverController == null) {
            throw new IllegalStateException("Must connect to server before playing game!");
        }

        // Start the game
        System.out.println("Starting a new game!");
        serverController.startGame();

        // Set up scanner for user input
        Scanner in = new Scanner(System.in);

        // Keep making moves until the game is over
        while (!serverController.checkIsGameOver()) {
            // Display board every turn
            displayBoard(serverController.retrieveBoardState());

            int inputMoveCode = promptForMove(in);

            // Check for exit code
            if (inputMoveCode == -99) {
                closeConnection();
                System.out.println("Game has ended. Thanks for playing!");
                return;
            }

            // Interpret move direction and perform proper move
            interpretMove(inputMoveCode);

        }

        // Display final board state
        displayBoard(serverController.retrieveBoardState());

        // Once game is over, check for status
        if (serverController.checkWinCondition()) {
            System.out.println("You won the game! :)");
        }
        else if (serverController.checkLoseCondition()) {
            System.out.println("You lost the game :(");
        }
        else {
            System.out.println("Game ended unexpectedly.");
        }
    }

    public void displayBoard(int[][] board) {
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                // display value
                String displayVal = board[i][j] == EMPTY_TILE_NUM ? " " : String.valueOf(board[i][j]);
                System.out.printf("\t%-4s\t|", displayVal);
            }
            System.out.println("\n-------------------------------------------------");
        }
    }

    public int promptForMove(Scanner in) {
        System.out.print("Enter next move (1 for up, 2 for right, 3 for down, 4 for left, -99 to QUIT): ");
        return in.nextInt();
    }

    public void interpretMove(int moveCode) {
        // Perform move and print result
        switch (moveCode) {
            case 1:
                System.out.println(serverController.moveUp());
                break;
            case 2:
                System.out.println(serverController.moveRight());
                break;
            case 3:
                System.out.println(serverController.moveDown());
                break;
            case 4:
                System.out.println(serverController.moveLeft());
                break;
            default:
                System.out.println("Cannot interpret move. Please try again");
        }
    }

    /**
     * Connects to the server. I assume that I can establish connection with server by reference for this simple
     * application. In a real application, you'd build proper communication (e.g. HTTP or sockets) between client
     * and server API
     * @param serverController ref to server API controller
     */
    public void connectToServer(ServerController serverController) {
        this.serverController = serverController;
    }

    public void closeConnection() {
        if (this.serverController != null) {
            System.out.println(serverController.stopGame());
        }

        this.serverController = null;
    }

    public static void main(String[] args) {
        SimpleClient sc = new SimpleClient();
        ServerController mc = new ServerController();

        sc.connectToServer(mc);
        sc.playGame();
    }
}
