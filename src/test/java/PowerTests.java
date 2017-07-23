import org.junit.Test;

import su.levenetc.playground.java.algs.Power;

import static org.junit.Assert.assertEquals;

public class PowerTests {
    @Test
    public void test01() {
        assertEquals(8f, Power.get(2, 3), 0);
    }

    @Test
    public void test02() {
        assertEquals(1024f, Power.get(2, 10), 0);
    }

    @Test
    public void test03() {
        assertEquals(2187f, Power.get(3, 7), 0);
    }

    @Test
    public void test04() {
        assertEquals(0.25f, Power.get(2, -2), 0);
    }

    @Test
    public void test05() {
        assertEquals(-8f, Power.get(-2, 3), 0);
    }
}
