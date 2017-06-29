import org.junit.Test;

import su.levenetc.playground.java.algs.SumOfTwo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.utils.Utils.array;

/**
 * Created by eugene.levenetc on 30/06/2017.
 */
public class SumOfTwoTests {
    @Test
    public void test01() {
        assertTrue(SumOfTwo.hasSum(array(1, 2, 3), array(5, 2, 4), 8));
    }

    @Test
    public void test02() {
        assertFalse(SumOfTwo.hasSum(array(1, 2, 3), array(5, 2, 4), 100));
    }
}
