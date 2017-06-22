import org.junit.Test;

import su.levenetc.playground.java.algs.RotateMatrix;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by eugene.levenetc on 22/06/2017.
 */
public class TestRotateMatrix {
    @Test
    public void test01() {
        final int[][] result = RotateMatrix.rotate(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        });
        assertArrayEquals(new int[][]{
                new int[]{7, 4, 1},
                new int[]{8, 5, 2},
                new int[]{9, 6, 3}
        }, result);
    }
}
