package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.MaxProfit.get;

public class MaxProfitTests {
    @Test
    public void test(){
        assertEquals(4, get(1, 2, 5, 1, 3));
        assertEquals(3, get(5, 2, 5, 1, 3));
        assertEquals(2, get(5, 7, 5, 1, 3));
    }
}
