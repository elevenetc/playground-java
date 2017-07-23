import org.junit.Test;

import su.levenetc.playground.java.algs.Power;

import static org.junit.Assert.assertEquals;

public class PowerTests {
    @Test
    public void test01() {
        assertEquals(8, Power.get(2, 3));
    }

    @Test
    public void test02() {
        assertEquals(1024, Power.get(2, 10));
    }

    @Test
    public void test03() {
        assertEquals(2187, Power.get(3, 7));
    }
}
