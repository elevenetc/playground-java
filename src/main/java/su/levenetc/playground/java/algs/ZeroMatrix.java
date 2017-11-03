package su.levenetc.playground.java.algs;

public class ZeroMatrix {

    static int[][] nullify(int[][] matrix) {

        for (int r = 1; r < matrix.length; r++) {
            int[] row = matrix[r];
            for (int c = 1; c < row.length; c++) {
                int value = matrix[r][c];
                if (value == 0) {
                    matrix[0][c] = 0;
                    matrix[r][0] = 0;
                }
            }
        }

        boolean topRowIsNull = false;
        boolean rightColIsNull = false;

        for (int r = 0; r < matrix.length; r++) {
            if (matrix[r][0] == 0) {

                if (r == 0) topRowIsNull = true;

                nullifyRow(matrix, r);
            }
        }

        for (int c = 0; c < matrix[0].length; c++) {
            if (matrix[0][c] == 0) {

                if (c == 0) rightColIsNull = true;

                nullifyCol(matrix, c);
            }
        }

        if (topRowIsNull) {
            nullifyRow(matrix, 0);
        }

        if (rightColIsNull) {
            nullifyCol(matrix, 0);
        }

        return matrix;
    }

    static int[][] nullifyRow(int[][] matrix, int row) {
        for (int c = 1; c < matrix[row].length; c++) {
            matrix[row][c] = 0;
        }
        return matrix;
    }

    static int[][] nullifyCol(int[][] matrix, int col) {
        for (int r = 1; r < matrix.length; r++) {
            matrix[r][col] = 0;
        }
        return matrix;
    }

}
