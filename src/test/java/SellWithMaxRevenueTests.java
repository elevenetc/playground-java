import org.junit.Test;

import su.levenetc.playground.java.algs.SellWithMaxRevenue;
import su.levenetc.playground.java.utils.Utils;

import static org.junit.Assert.assertEquals;

public class SellWithMaxRevenueTests {
    @Test
    public void test01() {
        assertEquals(5, SellWithMaxRevenue.get(Utils.array(5, 10)));
    }

    @Test
    public void test02() {
        assertEquals(17, SellWithMaxRevenue.get(Utils.array(5, 10, 3, 11, 20)));
    }
}
