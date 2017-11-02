package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.utils.Out;

public class RotateImageMatrixTests {
    @Test
    public void test01() {
        int[][] result = RotateImageMatrix.rotate90(new int[][]{
                new int[]{0, 1, 2, 3, 4},
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0}
        });
    }

    @Test
    public void test02() {
        int[][] result = RotateImageMatrix.rotate90(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        });
        Out.pln(result);
    }

    @Test
    public void test03() {
        int[][] img = RotateImageMatrix.rotateCell(new int[][]{
                new int[]{0, 1, 0},
                new int[]{4, 0, 2},
                new int[]{0, 3, 0}
        }, 1, 0);
        Out.pln(img);
    }

}
