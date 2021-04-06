package server.models;

public class ArrayHelpers implements Constants {
    // Reverse array order
    public static int[] reverseArr(int[] origArr) {
        int[] revArr = new int[origArr.length];
        for (int i = 0; i < origArr.length / 2; i++) {
            revArr[i] = origArr[(origArr.length - i) - 1];
            revArr[(origArr.length - i) - 1] = origArr[i];
        }
        return revArr;
    }

    // Extract the column of a 2D array
    public static int[] getColumnArr(int[][] twoDimArr, int col) {
        int[] columnArr = new int[twoDimArr[col].length];

        for (int i = 0; i < columnArr.length; i++) {
            columnArr[i] = twoDimArr[i][col];
        }

        return columnArr;
    }

    // Create a 1D array with empty tiles
    public static int[] createArrWithFillValue(int length, int fillValue) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = fillValue;
        }

        return arr;
    }

    // Create a 2D array with empty tiles
    public static int[][] createArr2DWithFillValue(int rowCount, int colCount, int fillValue) {
        int[][] arr2D = new int[rowCount][];

        for (int i = 0; i < rowCount; i++) {
            arr2D[i] = new int[colCount];
            for (int j = 0; j < colCount; j++) {
                arr2D[i][j] = fillValue;
            }
        }

        return arr2D;
    }
}
