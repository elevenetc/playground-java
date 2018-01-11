package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.MinSubArrayLen.get;
import static su.levenetc.playground.java.algs.MinSubArrayLen.get2;

public class MinSubArrayLenTests {
    @Test
    public void test() {
        check(3, 11, 1, 2, 3, 4, 5);
        check(1, 5, 1, 2, 3, 4, 5);
    }

    private void check(int expected, int sum, int... nums) {
        assertEquals(expected, get(sum, nums));
        assertEquals(expected, get2(sum, nums));
    }
}
