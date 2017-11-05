package su.levenetc.playground.java.algs;

import org.junit.Test;

import static su.levenetc.playground.java.algs.TwoNumSum.sumReverse;
import static su.levenetc.playground.java.datastructures.IntNode.list;
import static su.levenetc.playground.java.utils.TestUtils.assertEquals;

public class TwoNumSumTests {
    @Test
    public void testReverse() {
        assertEquals(9, sumReverse(list(5), list(4)));
        assertEquals(15, sumReverse(list(5), list(0, 1)));
        assertEquals(198, sumReverse(list(9, 9), list(9, 9)));
    }
}
