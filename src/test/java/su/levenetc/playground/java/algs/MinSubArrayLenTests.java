package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.MinSubArrayLen.get;
import static su.levenetc.playground.java.algs.MinSubArrayLen.get2;

public class MinSubArrayLenTests {
    @Test
    public void test() {

        assertEquals(3, get(11, 1, 2, 3, 4, 5));
        assertEquals(3, get2(11, 1, 2, 3, 4, 5));
    }
}
