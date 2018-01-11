package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.WaterTrap.get1;
import static su.levenetc.playground.java.algs.WaterTrap.get2;

public class WaterTrapTests {
    @Test
    public void test() {
        test(6, 0,1,0,2,1,0,1,3,2,1,2,1);
    }

    static void test(int expect, int... h) {
        assertEquals(expect, get1(h));
        assertEquals(expect, get2(h));
    }
}
