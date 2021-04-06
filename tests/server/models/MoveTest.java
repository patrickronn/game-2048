package server.models;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MoveTest implements Constants{
    @Test
    public void testLeftMoveNoChange() {
        int[][] orig2DArr = {
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
        };

        Move move = new LeftMove();

        int[][] updatedArray = move.makeMove(orig2DArr);

        // Array should not have changed values
        assertArrayEquals(orig2DArr, updatedArray);
    }

    @Test
    public void testRightMoveNoChange() {
        int[][] orig2DArr = {
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
        };

        Move move = new RightMove();

        int[][] updatedArray = move.makeMove(orig2DArr);

        // Array should not have changed values
        assertArrayEquals(orig2DArr, updatedArray);
    }

    @Test
    public void testUpMoveNoChange() {
        int[][] orig2DArr = {
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
        };

        Move move = new UpMove();

        int[][] updatedArray = move.makeMove(orig2DArr);

        // Array should not have changed values
        assertArrayEquals(orig2DArr, updatedArray);
    }

    @Test
    public void testDownMoveNoChange() {
        int[][] orig2DArr = {
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
        };

        Move move = new DownMove();

        int[][] updatedArray = move.makeMove(orig2DArr);

        // Array should not have changed values
        assertArrayEquals(orig2DArr, updatedArray);
    }

    @Test
    public void testLeftMoveMultipleChange() {
        int[][] orig2DArr = {
                {2, 2, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {2, 2, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {2, 2, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {2, 2, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
        };

        int[][] expectedArray = {
                {4, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {4, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {4, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {4, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
        };

        Move move = new LeftMove();

        int[][] updatedArray = move.makeMove(orig2DArr);

        // Array should not have changed values
        assertArrayEquals(expectedArray, updatedArray);
    }

    @Test
    public void testRightMoveMultipleChange() {
        int[][] orig2DArr = {
                {2, 2, EMPTY_TILE_NUM, 4},
                {2, 2, EMPTY_TILE_NUM, 4},
                {2, 2, EMPTY_TILE_NUM, 4},
                {2, 2, EMPTY_TILE_NUM, 4},
        };

        int[][] expectedArray = {
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, 4, 4},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, 4, 4},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, 4, 4},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, 4, 4},
        };

        Move move = new RightMove();

        int[][] updatedArray = move.makeMove(orig2DArr);

        // Array should not have changed values
        assertArrayEquals(expectedArray, updatedArray);
    }

    @Test
    public void testUpMoveMultipleChange() {
        int[][] orig2DArr = {
                {2, 2, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {2, 2, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
        };

        int[][] expectedArray = {
                {4, 4, 4, 4},
                {4, 4, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
        };

        Move move = new UpMove();

        int[][] updatedArray = move.makeMove(orig2DArr);

        // Array should not have changed values
        assertArrayEquals(expectedArray, updatedArray);
    }

    @Test
    public void testDownMoveMultipleChange() {
        int[][] orig2DArr = {
                {2, 2, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {2, 2, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
        };

        int[][] expectedArray = {
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {4, 4, EMPTY_TILE_NUM, EMPTY_TILE_NUM},
                {4, 4, 4, 4}
        };

        Move move = new DownMove();

        int[][] updatedArray = move.makeMove(orig2DArr);

        // Array should not have changed values
        assertArrayEquals(expectedArray, updatedArray);
    }
}