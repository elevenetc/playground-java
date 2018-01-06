package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.MaximumSizeOfSubArrayEqualsK.get;

public class MaximumSizeOfSubArrayEqualsKTests {
    @Test
    public void test() {
        assertEquals(4, get(3, 1, -1, 5, -2, 3));
        assertEquals(2, get(1, -2, -1, 2, 1));
        assertEquals(15, get(11, 1, -1, 5, -2, 3, 1, 3, -5, 10, 11, 1, 1, 1, 1, 4, 3, 2, 1, 1, -5, -10, 1, 5, 3, 2));
    }
}
