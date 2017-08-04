import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static su.levenetc.playground.java.algs.SpiralMatrix.get;
import static su.levenetc.playground.java.utils.Utils.range;

public class SpiralMatrixTests {
    @Test
    public void test01() {
        assertThat(get(new int[][]{
                new int[]{0, 1, 2},
                new int[]{7, 8, 3},
                new int[]{6, 5, 4},
        }), is(range(0, 8)));
    }

    @Test
    public void test02() {
        assertThat(get(new int[][]{
                new int[]{0, 1, 2, 3},
                new int[]{11, 12, 13, 4},
                new int[]{10, 15, 14, 5},
                new int[]{9, 8, 7, 6}
        }), is(range(0, 15)));
    }
}
