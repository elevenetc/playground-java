import org.junit.Test;
import su.levenetc.playground.java.algs.GrowingMedian;
import su.levenetc.playground.java.algs.GrowingMedianImpl;
import su.levenetc.playground.java.algs.GrowingMedianImpl2;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 10/03/2017.
 */
public class TestGrowingMedian {
    @Test
    public void smallValues() {
        smallValues(new GrowingMedianImpl(6));
        smallValues(new GrowingMedianImpl2());
    }

    @Test
    public void largeValues() {
        largeValues(new GrowingMedianImpl(3));
        largeValues(new GrowingMedianImpl2());
    }

    private void largeValues(GrowingMedian growingMedian) {
        assertEquals(94455, growingMedian.add(94455).getMedian(), 0);
        assertEquals(57505, growingMedian.add(20555).getMedian(), 0);
        assertEquals(20555, growingMedian.add(20535).getMedian(), 0);
    }

    private void smallValues(GrowingMedian growingMedian) {
        assertEquals(12.0f, growingMedian.add(12).getMedian(), 0);
        assertEquals(8.0f, growingMedian.add(4).getMedian(), 0);
        assertEquals(5.0f, growingMedian.add(5).getMedian(), 0);
        assertEquals(4.5f, growingMedian.add(3).getMedian(), 0);
        assertEquals(5.0f, growingMedian.add(8).getMedian(), 0);
        assertEquals(6.0f, growingMedian.add(7).getMedian(), 0);
    }
}
