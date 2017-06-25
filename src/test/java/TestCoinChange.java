import org.junit.Test;

import su.levenetc.playground.java.algs.CoinChange;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 23/06/2017.
 */
public class TestCoinChange {
    @Test
    public void test01() {
        assertEquals(10, CoinChange.coinChange(10, 1));
    }

    @Test
    public void test02() {
        assertEquals(2, CoinChange.coinChange(7, 2, 1, 5));
    }
}
