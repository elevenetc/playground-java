package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.SumOfPrimes.get;
import static su.levenetc.playground.java.utils.Utils.list;

public class SumOfPrimesTests {
    @Test
    public void test() {
        assertEquals(list(3, 7), get(10));
        assertEquals(list(2, 2), get(4));
        assertEquals(list(5, 373), get(378));
        assertEquals(list(31, 16777183), get(16777214));
    }
}
