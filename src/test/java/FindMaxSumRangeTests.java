import org.junit.Test;
import su.levenetc.playground.java.algs.FindMaxSumRange;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by eugene.levenetc on 15/05/2017.
 */
public class FindMaxSumRangeTests {
    @Test
    public void test01() {
        assertArrayEquals(new int[]{1, 3}, FindMaxSumRange.get(new int[]{0, 1, 1, 1, 0}));
        assertArrayEquals(new int[]{1, 2}, FindMaxSumRange.get(new int[]{0, 1, 1, -1, 0}));
        assertArrayEquals(new int[]{1, 5}, FindMaxSumRange.get(new int[]{-1, 2, 4, -3, 5, 2, -5, 2}));
    }
}
