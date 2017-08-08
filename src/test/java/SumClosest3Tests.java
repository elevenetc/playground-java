import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.SumClosest3.get;

public class SumClosest3Tests {
    @Test
    public void test01() {
        assertEquals(2, get(1, -1, 2, 1, -4));
    }

    @Test
    public void test02() {
        assertEquals(100, get(50, -100, 1, 49, 50, 100));
    }
}
