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
}
