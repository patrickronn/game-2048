package server.models;


/**
 * Abstract class that defines how a particular move affects a board state (2D integer array).
 * Efficiency assumption: We don't expect the board to have a large length (e.g. length 4),
 *  thus O(n^2) time complexity will not affect performance.
 */
public abstract class Move implements Constants {
    public abstract int[][] makeMove(int[][] board);

    /**
     * Slide the integers to the front of the array (towards index 0) and allows for collisions of the same value.
     * @param originalArr array to slide
     * @return updated array with values slid
     */
    protected int[] slideToFrontOfArr(int[] originalArr) {
        int[] updatedArr = ArrayHelpers.createArrWithFillValue(originalArr.length, EMPTY_TILE_NUM);

        // Copy the first element
        updatedArr[0] = originalArr[0];

        // Track the last collision that happened
        int lastCollisionIdx = -1;

        for (int i = 1; i < originalArr.length; i++) {
            // If empty, continue to next element
            if (originalArr[i] == EMPTY_TILE_NUM) {
                continue;
            }

            int j = i - 1;

            // Search for index of a non-empty tile or until beginning of array is reached
            while (updatedArr[j] == EMPTY_TILE_NUM && j > 0) {
                j--;
            }

            // If collision occurred past the last collision index, combine values
            if ((j > lastCollisionIdx) && (updatedArr[j] == originalArr[i])) {
                updatedArr[j] *= 2;
                updatedArr[j + 1] = EMPTY_TILE_NUM;
                lastCollisionIdx = j;
            }
            // If non-empty tile was found (including j at index 0 isn't empty), then put tile beside it
            else if (updatedArr[j] != EMPTY_TILE_NUM) {
                updatedArr[j + 1] = originalArr[i];
            }
            // If beginning of array was reached (and was empty), move tile to beginning
            else {
                updatedArr[j] = originalArr[i];
            }
        }

        return updatedArr;
    }
}
