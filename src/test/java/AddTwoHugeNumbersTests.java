import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.AddTwoHugeNumbers.fixLeadingZeroAndSplit;
import static su.levenetc.playground.java.algs.AddTwoHugeNumbers.formattedSum;
import static su.levenetc.playground.java.algs.AddTwoHugeNumbers.removeLeadingZeroes;
import static su.levenetc.playground.java.algs.AddTwoHugeNumbers.splitInt;
import static su.levenetc.playground.java.algs.AddTwoHugeNumbers.splitInts;
import static su.levenetc.playground.java.algs.AddTwoHugeNumbers.sum;
import static su.levenetc.playground.java.utils.Utils.linkedList;
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

    @Test
    public void testFixLeadingZeros() {
        assertEquals(list(1, 0, 0, 0), fixLeadingZeroAndSplit(1000));
        assertEquals(list(0, 9, 0, 0), fixLeadingZeroAndSplit(900));
        assertEquals(list(0, 0, 5, 5), fixLeadingZeroAndSplit(55));
        assertEquals(list(0, 0, 0, 1), fixLeadingZeroAndSplit(1));
    }

    @Test
    public void formattedTests() {
        assertEquals(list(2, 0, 0, 0, 2), formattedSum(linkedList(1, 1), linkedList(1, 1)));
        assertEquals(list(4), formattedSum(linkedList(2), linkedList(2)));
    }

    @Test
    public void removeLeadingZeroesTests() {
        assertEquals(linkedList(1), removeLeadingZeroes(linkedList(0, 0, 0, 1)));
        assertEquals(linkedList(1, 1), removeLeadingZeroes(linkedList(0, 0, 1, 1)));
        assertEquals(linkedList(8, 1, 1), removeLeadingZeroes(linkedList(0, 8, 1, 1)));
        assertEquals(linkedList(6, 8, 1, 1), removeLeadingZeroes(linkedList(6, 8, 1, 1)));
        assertEquals(linkedList(9, 1), removeLeadingZeroes(linkedList(9, 0, 0, 0, 1)));
    }
}
