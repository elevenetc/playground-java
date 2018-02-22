package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.SumOfTwoPrimes.get;
import static su.levenetc.playground.java.utils.Utils.list;

public class SumOfTwoPrimesTests {
    @Test
    public void test() {
        assertEquals(list(3, 7), get(10));
        assertEquals(list(2, 2), get(4));
        assertEquals(list(3, 375), get(378));
        assertEquals(list(3, 16777211), get(16777214));
    }
}
