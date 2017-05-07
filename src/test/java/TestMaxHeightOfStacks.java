import org.junit.Test;
import su.levenetc.playground.java.algs.MaxHeightOfStacks;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 07/05/2017.
 */
public class TestMaxHeightOfStacks {
    @Test
    public void test01() {
        assertEquals(5, MaxHeightOfStacks.get(
                new int[]{3, 2, 1, 1, 1},
                new int[]{4, 3, 2},
                new int[]{1, 1, 4, 1}
        ));
    }
}
