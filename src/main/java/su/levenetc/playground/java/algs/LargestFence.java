package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 30/04/2017.
 * https://www.hackerrank.com/challenges/mr-k-marsh
 */
public class LargestFence {

    public static int get(char[][] field) {
        int result = 0;
        for (int r = 0; r < field.length; r++) {
            char[] row = field[r];
            for (int c = 0; c < row.length; c++) {
                result = Math.max(findMax(r, c, field), result);
            }
        }
        return result;
    }

    static int findMax(int rStart, int cStart, char[][] field) {

        int result = 0;

        for (int r = field.length - 1; r >= 0; r--) {

            char[] row = field[r];
            if (r == rStart) continue;

            for (int c = row.length - 1; c >= 0; c--) {
                if (cStart == c) continue;

                int width = addOne((c - cStart) * -1);
                int height = addOne((r - rStart) * -1);

                if (Math.abs(width) <= 1 || Math.abs(height) <= 1) continue;

                int perim = Math.abs(width) * 2 + Math.abs(height) * 2 - 4;

                if (perim > result && isFit(field, r, c, width, height)) {
                    result = Math.max(result, perim);
                }
            }
        }

        return result;
    }

    public static boolean isFit(char[][] field, int r, int c, int width, int height) {

        if (field[r][c] == 'x') return false;


        int column = c;
        int colDir = width > 0 ? 1 : -1;

        int row = r;
        int rowDir = height > 0 ? 1 : -1;

        char[] rowA = field[r];
        char[] rowB = field[r + height + (-1) * rowDir];

        while (column != c + width) {
            if (rowA[column] == 'x') {
                return false;
            }
            if (rowB[column] == 'x') {
                return false;
            }
            column += colDir;
        }

        while (row != r + height) {
            if (field[row][c] == 'x') {
                return false;
            }
            if (field[row][c + width + (-1) * colDir] == 'x') {
                return false;
            }
            row += rowDir;
        }

        return true;

    }

    static int addOne(int value) {
        if (value > 0) {
            return value + 1;
        } else {
            return value - 1;
        }
    }
}