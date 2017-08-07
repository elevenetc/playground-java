package su.levenetc.playground.java.algs;

public class Rotate2DMatrix {
    public static int[][] rotate90Clockwise(int[][] matrix) {

        int rowIndex = 0;
        int colIndex = 0;
        int leftBound = 0;
        int rightBound = matrix.length - 1;

        boolean even = (matrix.length / 2) % 2 == 0;
        int half = matrix.length / 2;

        while (half > 0) {

            for (colIndex = leftBound; colIndex < rightBound; colIndex++) {
                rotateInternal(matrix, rowIndex, colIndex, leftBound, rightBound);
            }

            rightBound--;
            leftBound++;
            rowIndex++;

            half--;
        }


        return matrix;
    }

    private static void rotateInternal(int[][] matrix, int rowIndex, int colIndex, int leftBound, int rightBound) {
        int size = rightBound - leftBound;

        int leftTop = matrix[rowIndex][colIndex];
        int rightTop = matrix[colIndex][rightBound];
        int rightBottom = matrix[size - rowIndex][rightBound - colIndex];
        int leftBottom = matrix[size - colIndex][leftBound];


        matrix[rowIndex][colIndex] = leftBottom;
        matrix[colIndex][rightBound] = leftTop;
        matrix[size - rowIndex][rightBound - colIndex] = rightTop;
        matrix[size - colIndex][leftBound] = rightBottom;
    }
}