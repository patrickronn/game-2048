package server.models;

/**
 * Slides tiles to bottom of the board
 */
public class DownMove extends Move {
    @Override
    public int[][] makeMove(int[][] currentBoardState) {
        int[][] updatedBoardState = ArrayHelpers.createArr2DWithFillValue(
                currentBoardState.length, currentBoardState[0].length, EMPTY_TILE_NUM);

        // Traverse each column and slide it
        for (int j = 0; j < currentBoardState[0].length; j++) {
            // Extract each column as an int array
            int[] columnArr = ArrayHelpers.getColumnArr(currentBoardState, j);

            // Reverse the array
            int[] reverseOrigColumnArr = ArrayHelpers.reverseArr(columnArr);

            // Slide array
            int[] reverseUpdatedColumnArr = slideToFrontOfArr(reverseOrigColumnArr);

            // Undo the reverse order
            int[] updatedColumnArr = ArrayHelpers.reverseArr(reverseUpdatedColumnArr);

            // Add column to updated board state
            for (int i = 0; i < updatedBoardState.length; i++) {
                updatedBoardState[i][j] = updatedColumnArr[i];
            }
        }

        return updatedBoardState;
    }
}
