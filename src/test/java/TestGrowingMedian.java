import org.junit.Test;
import su.levenetc.playground.java.algs.GrowingMedian;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 10/03/2017.
 */
public class TestGrowingMedian {
    @Test
    public void test() {
        final GrowingMedian growingMedian = new GrowingMedian(6);
        assertEquals(12.0f, growingMedian.add(12), 0);
        assertEquals(8.0f, growingMedian.add(4), 0);
        assertEquals(5.0f, growingMedian.add(5), 0);
        assertEquals(4.5f, growingMedian.add(3), 0);
        assertEquals(5.0f, growingMedian.add(8), 0);
        assertEquals(6.0f, growingMedian.add(7), 0);
    }
}
