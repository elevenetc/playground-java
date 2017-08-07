import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static su.levenetc.playground.java.algs.Rotate2DMatrix.rotate90Clockwise;

public class Rotate2DMatrixTests {
    @Test
    public void test01() {
        assertArrayEquals(new int[][]{
                new int[]{7, 4, 1},
                new int[]{8, 5, 2},
                new int[]{9, 6, 3}
        }, rotate90Clockwise(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }));
    }
}
