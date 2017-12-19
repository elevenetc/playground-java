package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.ReverseInteger.reverse;

public class ReverseIntegerTests {
    @Test
    public void test() {
        assertEquals(105, reverse(501));
        assertEquals(-105, reverse(-501));
        assertEquals(111, reverse(111));
        assertEquals(1, reverse(100));
        assertEquals(21, reverse(120));
        assertEquals(-9, reverse(-9));
        assertEquals(0, reverse(1534236469));
        assertEquals(0, reverse(0));
    }
}
