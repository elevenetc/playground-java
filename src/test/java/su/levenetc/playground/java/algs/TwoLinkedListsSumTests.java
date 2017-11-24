package su.levenetc.playground.java.algs;

import org.junit.Test;

import static su.levenetc.playground.java.algs.TwoLinkedListsSum.sumDirect;
import static su.levenetc.playground.java.algs.TwoLinkedListsSum.sumReverse;
import static su.levenetc.playground.java.datastructures.ListNode.list;
import static su.levenetc.playground.java.utils.TestUtils.assertEquals;

public class TwoLinkedListsSumTests {
    @Test
    public void testReverse() {
        assertEquals(9, sumReverse(list(5), list(4)));
        assertEquals(15, sumReverse(list(5), list(0, 1)));
        assertEquals(198, sumReverse(list(9, 9), list(9, 9)));
        assertEquals(180, sumReverse(list(9, 9), list(1, 8)));
    }

    @Test
    public void testDirect() {
        assertEquals(list(1, 7, 8), sumDirect(list(1, 2, 3), list(5, 5)));
        assertEquals(list(2), sumDirect(list(1), list(1)));
        assertEquals(list(1, 9, 9), sumDirect(list(9, 9), list(1, 0, 0)));
        assertEquals(list(1, 8, 0), sumDirect(list(9, 9), list(8, 1)));
    }
}
