import org.junit.Test;
import su.levenetc.playground.java.algs.MaxKillPerTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 17/05/2017.
 */
public class MaxKillPerTimeTests {
    @Test
    public void test01() {
        assertEquals(4, MaxKillPerTime.getMaxMonsters(8, 6, new int[]{16, 19, 7, 11, 23, 8, 16}));
    }
}
