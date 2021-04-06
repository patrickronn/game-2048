package server.models;

/**
 * Slides tiles to the top of the board
 */
public class UpMove extends Move {
    @Override
    public int[][] makeMove(int[][] currentBoardState) {
        int[][] updatedBoardState = ArrayHelpers.createArr2DWithFillValue(
                currentBoardState.length, currentBoardState[0].length, EMPTY_TILE_NUM);

        // Traverse each column and slide it
        for (int j = 0; j < currentBoardState[0].length; j++) {
            // Extract each column as an int array
            int[] columnArr = ArrayHelpers.getColumnArr(currentBoardState, j);

            // Slide array
            int[] updatedColumnArr = slideToFrontOfArr(columnArr);

            // Add column to updated board state
            for (int i = 0; i < updatedBoardState.length; i++) {
                updatedBoardState[i][j] = updatedColumnArr[i];
            }
        }

        return updatedBoardState;
    }
}
