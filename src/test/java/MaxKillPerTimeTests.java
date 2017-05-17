import org.junit.Test;
import su.levenetc.playground.java.algs.MaxKillPerTime;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 17/05/2017.
 */
public class MaxKillPerTimeTests {
    @Test
    public void test01() {
        assertEquals(4, MaxKillPerTime.getMaxMonsters(8, 6,
                new int[]{16, 19, 7, 11, 23, 8, 16})
        );
    }

    @Test
    public void tes02t() {
        assertEquals(4, MaxKillPerTime.getMaxMonsters(1, 4,
                new int[]{1, 1, 1, 1})
        );
    }

    @Test
    public void test03() {
        assertEquals(0, MaxKillPerTime.getMaxMonsters(1, 4,
                new int[]{100, 100, 100, 100})
        );
    }

    @Test
    public void test04() {
        assertEquals(2, MaxKillPerTime.getMaxMonsters(100, 2,
                new int[]{100, 100, 100, 100})
        );
    }

    @Test
    public void test05() {
        assertEquals(1, MaxKillPerTime.getMaxMonsters(50, 2,
                new int[]{100, 100, 100, 100})
        );
    }
}