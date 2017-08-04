package su.levenetc.playground.java.algs;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> get(int[][] matrix) {
        LinkedList<Integer> result = new LinkedList<>();

        int length = matrix.length;
        boolean even = length % 2 == 0;
        int col = 0;
        int row = 0;

        while (length > 1) {
            grab(matrix, col, row, length, result);
            col++;
            row++;
            length -= 2;
        }

        if (!even) {
            int mid = matrix.length / 2;
            result.add(matrix[mid][mid]);
        }

        return result;
    }

    static void grab(int[][] matrix, int col, int row, int size, List<Integer> result) {

        //top
        int max;
        int min;

        max = col + size;
        for (; col < max; col++) {
            result.add(matrix[row][col]);
        }

        //right
        col--;
        row++;
        max = row + size - 1;
        for (; row < max; row++) {
            result.add(matrix[row][col]);
        }

        //bottom
        row--;
        col--;
        min = col - size + 1;
        for (; col > min; col--) {
            result.add(matrix[row][col]);
        }

        //left
        row--;
        col++;
        min = row - size + 2;
        for (; row > min; row--) {
            result.add(matrix[row][col]);
        }
    }

}