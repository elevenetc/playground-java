package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.SingleNumber.get;

public class SingleNumberTests {
    @Test
    public void test() {
        assertEquals(3, get(1, 3, 1, 2, 2, 5, 5));
    }
}