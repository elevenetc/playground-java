package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.MaxSubArraySum.get;

public class MaxSubArraySumTests {
    @Test
    public void test() {
        assertEquals(6, get(-2, 1, -3, 4, -1, 2, 1, -5, 4));
        assertEquals(100, get(1, 2, 3, -100, 100));
        assertEquals(11, get(1, 1, 1, 5, -1, -2, 1, 5, -10, 1, 1, 1));
    }
}
