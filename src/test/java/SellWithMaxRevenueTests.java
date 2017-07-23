import org.junit.Test;

import su.levenetc.playground.java.algs.SellWithMaxRevenue;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.utils.Utils.array;

public class SellWithMaxRevenueTests {
    @Test
    public void test01() {
        assertEquals(5, SellWithMaxRevenue.getOneMax(array(5, 10)));
    }

    @Test
    public void test02() {
        assertEquals(17, SellWithMaxRevenue.getOneMax(array(5, 10, 3, 11, 20)));
    }

    @Test
    public void test03() {
        assertEquals(50, SellWithMaxRevenue.getMaxSum(array(50, 100)));
    }

    @Test
    public void test04() {
        assertEquals(95, SellWithMaxRevenue.getMaxSum(array(50, 100, 10, 5, 50)));
    }

    @Test
    public void test05() {
        assertEquals(865, SellWithMaxRevenue.getMaxSum(array(100, 180, 260, 310, 40, 535, 695)));
    }

    @Test
    public void test06() {
        assertEquals(100, SellWithMaxRevenue.getMaxSum(array(50, 100, 150)));
    }

    @Test
    public void test07() {
        assertEquals(60, SellWithMaxRevenue.getMaxSum(array(50, 100, 10, 20)));
    }

    @Test
    public void test08() {
        assertEquals(13, SellWithMaxRevenue.getMaxSum(array(1, 4, 5, 7, 6, 3, 2, 9)));
    }

    @Test
    public void test09() {
        assertEquals(3, SellWithMaxRevenue.getMaxSum(array(1, 4)));
    }

    @Test
    public void test10() {
        assertEquals(-1, SellWithMaxRevenue.getMaxSum(array(1)));
        assertEquals(-1, SellWithMaxRevenue.getMaxSum(array()));
    }

}
