import org.junit.Test;

import su.levenetc.playground.java.algs.SetMatrixZeroes;

import static org.junit.Assert.assertArrayEquals;

public class SetMatrxiZeroesTests {
    @Test
    public void test01() {
        assertArrayEquals(new int[][]{
                new int[]{1, 0, 3},
                new int[]{0, 0, 0},
                new int[]{1, 0, 3}
        }, SetMatrixZeroes.set(new int[][]{
                new int[]{1, 2, 3},
                new int[]{1, 0, 3},
                new int[]{1, 2, 3}
        }));
    }

    @Test
    public void test02() {
        assertArrayEquals(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 0, 0},
                new int[]{0, 0, 3}
        }, SetMatrixZeroes.set(new int[][]{
                new int[]{0, 2, 3},
                new int[]{1, 0, 3},
                new int[]{1, 2, 3}
        }));
    }

    @Test
    public void test03() {
        assertArrayEquals(new int[][]{
                new int[]{1, 2, 3, 0},
                new int[]{1, 2, 3, 0},
                new int[]{1, 2, 3, 0},
                new int[]{0, 0, 0, 0}
        }, SetMatrixZeroes.set(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{1, 2, 3, 4},
                new int[]{1, 2, 3, 4},
                new int[]{1, 2, 3, 0}
        }));
    }


}
