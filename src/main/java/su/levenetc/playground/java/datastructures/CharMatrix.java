package su.levenetc.playground.java.datastructures;

/**
 * Created by eugene.levenetc on 29/04/2017.
 */
public class CharMatrix {

    char[][] matrix;

    public void set(char[][] matrix) {
        this.matrix = matrix;
    }

    public void fill(String str, int col, int row, boolean horizontal) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (horizontal) {
                matrix[row][col++] = chars[i];
            } else {
                matrix[row++][col] = chars[i];
            }
        }
    }

    public void set(String[] rows) {
        matrix = new char[rows.length][];
        for (int r = 0; r < rows.length; r++) {
            String row = rows[r];
            matrix[r] = new char[rows.length];
            char[] chars = row.toCharArray();
            for (int c = 0; c < chars.length; c++) {
                char ch = chars[c];
                matrix[r][c] = ch;
            }
        }
    }

    public String[] toRows() {
        String[] result = new String[matrix.length];
        for (int r = 0; r < matrix.length; r++) {
            char[] row = matrix[r];
            for (int c = 0; c < row.length; c++) {
                char ch = row[c];
                if (c == 0) result[r] = "";
                result[r] += ch;
            }
        }
        return result;
    }

}
