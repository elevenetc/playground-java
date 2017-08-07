import org.junit.Test;

import su.levenetc.playground.java.utils.Utils;

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

    @Test
    public void test02() {
        assertArrayEquals(new int[][]{
                new int[]{13, 9, 5, 1},
                new int[]{14, 10, 6, 2},
                new int[]{15, 11, 7, 3},
                new int[]{16, 12, 8, 4}
        }, rotate90Clockwise(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16}
        }));
    }

    @Test
    public void test03() {
        assertArrayEquals(new int[][]{
                new int[]{21, 16, 11, 6, 1},
                new int[]{22, 17, 12, 7, 2},
                new int[]{23, 18, 13, 8, 3},
                new int[]{24, 19, 14, 9, 4},
                new int[]{25, 20, 15, 10, 5}
        }, rotate90Clockwise(new int[][]{
                Utils.arrayRange(1, 5),
                Utils.arrayRange(6, 10),
                Utils.arrayRange(11, 15),
                Utils.arrayRange(16, 20),
                Utils.arrayRange(21, 25)

        }));
    }


}
