package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.utils.Out;

public class ZeroMatrixTests {
    @Test
    public void testNullifyRow() {
        Out.pln(ZeroMatrix.nullifyRow(new int[][]{
                new int[]{1, 2, 3},
                new int[]{1, 2, 3},
                new int[]{1, 2, 3}
        }, 0));
    }

    @Test
    public void testNullifyCol() {
        Out.pln(ZeroMatrix.nullifyCol(new int[][]{
                new int[]{1, 2, 3},
                new int[]{1, 2, 3},
                new int[]{1, 2, 3}
        }, 0));
    }

    @Test
    public void testNullifyMatrix() {
        Out.pln(ZeroMatrix.nullify(new int[][]{
                new int[]{1, 2, 0},
                new int[]{1, 2, 3},
                new int[]{1, 2, 3}
        }));
    }

}
