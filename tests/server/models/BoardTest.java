package server.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static server.models.Constants.*;

public class BoardTest {
    private int[][] expectedBoard;

    @Before
    public void init() {
        // Set up the expected empty board (e.g. 4x4 board with 0's in all tile values
        expectedBoard = new int[BOARD_SIDE_LENGTH][BOARD_SIDE_LENGTH];
        for (int i = 0; i < BOARD_SIDE_LENGTH; i++) {
            for (int j = 0; j < BOARD_SIDE_LENGTH; j++) {
                expectedBoard[i][j] = EMPTY_TILE_NUM;
            }
        }

    }

    @Test
    public void testInitializeEmptyBoardValidLength() {
        Board board = new Board();

        assertArrayEquals(expectedBoard, board.getBoardState());
        assertEquals(0, board.getOccupiedCount());
    }

    @Test
    public void testAddNumAtTile() {
        int num = 2;
        int row = 0;
        int col = 0;
        expectedBoard[row][col] = num;
        int expectedOccupiedCount = 1;

        Board board = new Board();
        board.setNumAtTile(num, row, col);

        assertArrayEquals(expectedBoard, board.getBoardState());
        assertEquals(expectedOccupiedCount, board.getOccupiedCount());
    }

    /**
     * Ensure that setting a tile to be empty reduces the occupied tile count (if not already empty)
     */
    @Test
    public void testMakeEmptyAtTile() {
        int row = 0;
        int col = 0;

        Board board = new Board();
        board.setNumAtTile(48, row, col);

        // Expected occupied count should be 1
        assertEquals(1, board.getOccupiedCount());

        board.setNumAtTile(EMPTY_TILE_NUM, row, col);

        // Expected occupied count should be 0
        assertEquals(0, board.getOccupiedCount());

        board.setNumAtTile(EMPTY_TILE_NUM, row, col);

        // Expected occupied count should still be 0
        assertEquals(0, board.getOccupiedCount());
    }

    /**
     * checkWinner() should be true if winning num was added.
     */
    @Test
    public void testBoardWithWinnerTrue() {
        int row = (BOARD_SIDE_LENGTH - 1);
        int col = 0;

        Board board = new Board();
        board.setNumAtTile(WINNING_NUM, row, col);

        assertTrue(board.checkWinner());
    }

    /**
     * checkWinner() should be false if winning num wasn't added.
     */
    @Test
    public void testBoardWithWinnerFalse() {
        int row = (BOARD_SIDE_LENGTH - 1);
        int col = 0;

        Board board = new Board();
        board.setNumAtTile(WINNING_NUM - 1, row, col);

        assertFalse(board.checkWinner());
    }

    /**
     * checkLoser() should be true if all the tiles are filled and none are the winning number
     */
    @Test
    public void testBoardWithLoserTrue() {
        // Fill the board we expect
        int numToFill = 48;

        for (int i = 0; i < expectedBoard.length; i++) {
            Arrays.fill(expectedBoard[i], numToFill);
        }

        Board board = new Board();

        // Set board to the expected state
        for (int i = 0; i < board.getBoardState().length; i++) {
            for (int j = 0; j < board.getBoardState()[i].length; j++) {
                board.setNumAtTile(numToFill, i, j);
            }
        }

        assertTrue(board.checkLoser());
    }

    /**
     * checkLoser() should fail if the board is filled BUT if a winning number is included
     */
    @Test
    public void testBoardWithLoserFalse1() {
        // Set up a filled board to test with the winning num
        for (int i = 0; i < expectedBoard.length; i++) {
            Arrays.fill(expectedBoard[i], WINNING_NUM);
        }

        Board board = new Board();

        // Set board to the expected state
        for (int i = 0; i < board.getBoardState().length; i++) {
            for (int j = 0; j < board.getBoardState()[i].length; j++) {
                board.setNumAtTile(WINNING_NUM, i, j);
            }
        }

        assertFalse(board.checkLoser());
    }

    /**
     * checkLoser() should fail if the board isn't filled
     */
    @Test
    public void testBoardWithLoserFalse2() {
        int numToFill = 48;

        int row1 = BOARD_SIDE_LENGTH - 1;
        int col1 = 0;
        int row2 = 0;
        int col2 = BOARD_SIDE_LENGTH - 1;

        Board board = new Board();

        board.setNumAtTile(numToFill, row1, col1);
        board.setNumAtTile(numToFill, row2, col2);

        assertFalse(board.checkLoser());
    }
}