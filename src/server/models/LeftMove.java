package server.models;

/**
 * Slide tiles to the left
 */
public class LeftMove extends Move {

    @Override
    public int[][] makeMove(int[][] currentBoardState) {
        int[][] updatedBoardState = ArrayHelpers.createArr2DWithFillValue(
                currentBoardState.length, currentBoardState[0].length, EMPTY_TILE_NUM);

        // Traverse and slide each row
        for (int i = 0; i < currentBoardState.length; i++) {
            updatedBoardState[i] = slideToFrontOfArr(currentBoardState[i]);
        }

        return updatedBoardState;
    }
}
