package su.levenetc.playground.java.algs;

public class Search2DMatrix {
    public static boolean search(int[][] matrix, int value) {

        if (matrix[0][0] > value || matrix[matrix.length - 1][matrix.length - 1] < value)
            return false;

        return contains(matrix, 0, matrix.length - 1, value);
    }

    static boolean contains(int[][] matrix, int topRow, int bottomRow, int value) {

        if (topRow == bottomRow) return contains(matrix[topRow], value) == 0;

        int size = bottomRow - topRow + 1;
        boolean even = size % 2 == 0;

        int containsTop = contains(matrix[topRow], value);
        int containsBottom = contains(matrix[bottomRow], value);

        if (containsTop == 1) return true;
        if (containsBottom == 1) return true;

        if (even) {
            int midTop = size / 2 - 1;
            int midBottom = size / 2;

            int containsMidTop = contains(matrix[midTop], value);
            int containsMidBottom = contains(matrix[midBottom], value);

            if (containsMidTop == 0) return true;
            if (containsMidBottom == 0) return true;

            if (containsMidTop < 0) {
                return contains(matrix, topRow + 1, midTop - 1, value);
            } else {
                return contains(matrix, midBottom + 1, bottomRow - 1, value);
            }

        } else {
            int mid = size / 2;
            int containsMid = contains(matrix[mid], value);

            if (containsMid == 0) return true;

            if (containsMid < 0) {
                return contains(matrix, topRow + 1, mid - 1, value);
            } else {
                return contains(matrix, mid + 1, bottomRow - 1, value);
            }
        }
    }

    static int contains(int[] row, int value) {
        int last = row.length - 1;
        if (value >= row[0] && value <= row[last]) return 0;
        if (value > row[last]) return 1;
        return -1;
    }
}
