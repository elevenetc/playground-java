import org.junit.Test;
import su.levenetc.playground.java.algs.AlgorithmicCrush;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 17/04/2017.
 */
public class TestAlgCrush {
    @Test
    public void test01() {
        assertEquals(200, AlgorithmicCrush.getMax01(new int[][]{
                new int[]{0, 1, 100},
                new int[]{1, 4, 100},
                new int[]{2, 3, 100}
        }, 5));
    }

    @Test
    public void test02() {
        assertEquals(200, AlgorithmicCrush.getMax02(new int[][]{
                new int[]{0, 1, 100},
                new int[]{1, 4, 100},
                new int[]{2, 3, 100}
        }, 5));
    }
}