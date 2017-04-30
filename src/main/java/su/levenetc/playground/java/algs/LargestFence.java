package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 30/04/2017.
 */
public class LargestFence {

    public static void run(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            char[] row = field[r];
            for (int c = 0; c < row.length; c++) {
                findMax(r, c, field);
            }
        }
    }

    static int findMax(int r, int c, char[][] field) {
        return 0;
    }

    public static boolean isFit(char[][] field, int r, int c, int width, int height) {

        int column = c;
        int colDir = width > 0 ? 1 : -1;

        int row = r;
        int rowDir = height > 0 ? 1 : -1;

        char[] rowA = field[r];
        char[] rowB = field[r + height + (-1) * rowDir];

        while (column != c + width) {
            if (rowA[column] == 'x') return false;
            if (rowB[column] == 'x') return false;
            column += colDir;
        }

        while (row != r + height) {
            if (field[c][row] == 'x') return false;
            if (field[c + width + (-1) * colDir][row] == 'x') return false;
            row += rowDir;
        }

        return true;

    }
}