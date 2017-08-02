package su.levenetc.playground.java.algs;

import java.util.Arrays;

public class SetMatrixZeroes {

    public static int[][] set(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            int[] row = matrix[r];
            if (hasZero(row, matrix)) row[0] = 0;
        }

        int[] firstRow = matrix[0];
        for (int c = 1; c < firstRow.length; c++) {
            if (firstRow[c] == 0) {
                setZeroes(matrix, c);
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            int[] row = matrix[r];

            if (row[0] == 0) {
                setZeroes(row);
            }
        }

        if (matrix[0][0] == 0) {
            setZeroes(matrix[0]);
            setZeroes(matrix, 0);
        }

        return matrix;
    }

    static void setZeroes(int[] row) {
        Arrays.fill(row, 0);
    }

    static void setZeroes(int[][] matrix, int col) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r][col] = 0;
        }
    }

    static boolean hasZero(int[] array, int[][] matrix) {
        boolean foundZero = false;
        for (int c = 0; c < array.length; c++) {
            if (array[c] == 0) {
                matrix[0][c] = 0;
                foundZero = true;
            }
        }
        return foundZero;
    }
}
