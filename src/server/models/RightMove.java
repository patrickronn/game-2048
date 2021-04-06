package server.models;

/**
 * Slides tiles to the right
 */
public class RightMove extends Move {
    @Override
    public int[][] makeMove(int[][] currentBoardState) {
        int[][] updatedBoardState = ArrayHelpers.createArr2DWithFillValue(
                currentBoardState.length, currentBoardState[0].length, EMPTY_TILE_NUM);

        // Traverse and slide each row
        for (int i = 0; i < currentBoardState.length; i++) {
            // Reverse row's element order then slide it
            int[] reverseOrigRow = ArrayHelpers.reverseArr(currentBoardState[i]);
            int[] reverseUpdatedRow = slideToFrontOfArr(reverseOrigRow);

            // Reverse row's element order then assign it to updated board state
            int[] updatedRow = ArrayHelpers.reverseArr(reverseUpdatedRow);
            updatedBoardState[i] = updatedRow;
        }

        return updatedBoardState;
    }
}
