import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.AddTwoHugeNumbers.splitInt;
import static su.levenetc.playground.java.algs.AddTwoHugeNumbers.splitInts;
import static su.levenetc.playground.java.algs.AddTwoHugeNumbers.sum;
import static su.levenetc.playground.java.utils.Utils.list;

public class AddTwoHugeNumbersTests {
    @Test
    public void testSplitInt() {
        assertEquals(list(0), splitInt(0));
        assertEquals(list(1, 0), splitInt(10));
        assertEquals(list(9, 9, 9, 9), splitInt(9999));
    }

    @Test
    public void testSplitInts() {
        assertEquals(list(0), splitInts(list(0)));
        assertEquals(list(1, 0, 2, 2, 3, 3), splitInts(list(10, 22, 33)));
    }

    @Test
    public void test() {
        assertEquals(list(2), sum(list(1), list(1)));
        assertEquals(list(2, 0), sum(list(1, 0), list(1, 0)));
        assertEquals(list(8, 9), sum(list(3, 4), list(5, 5)));
        assertEquals(list(2, 0), sum(list(1, 3), list(7)));
        assertEquals(list(3, 0, 2), sum(list(2, 2, 4), list(7, 8)));
    }
}
