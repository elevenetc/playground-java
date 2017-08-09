import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.SumClosest3.get;

public class SumClosest3Tests {
    @Test
    public void test01() {
        //-1 + 1 + 2
        assertEquals(2, get(1, -1, 2, 1, -4));
    }

    @Test
    public void test02() {
        //100 + (-100) + 50
        assertEquals(50, get(50, -100, 1, 49, 50, 100));
    }

    @Test
    public void test03() {
        //9 + 9 + 1
        assertEquals(19, get(20, 1, 8, 8, 8, 9, 9));
    }

    @Test
    public void test04() {
        //2 + 1 + (-3)
        assertEquals(0, get(1, 0, 2, 1, -3));
    }

    @Test
    public void test05() {
        assertEquals(0, get(0, -55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33));
    }
}
