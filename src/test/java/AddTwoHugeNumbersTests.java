import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.AddTwoHugeNumbers.concatInt;
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
        assertEquals(list(223, 104, 105), formattedSum(linkedList(123, 4, 5), linkedList(100, 100, 100)));
        assertEquals(list(0), formattedSum(linkedList(0), linkedList(0)));
        assertEquals(list(1234, 1234, 0), formattedSum(linkedList(1234, 1234, 0), linkedList(0)));
        assertEquals(list(1234, 123, 0), formattedSum(linkedList(0), linkedList(1234, 123, 0)));
        assertEquals(list(9999, 0, 0, 0, 0, 0), formattedSum(linkedList(1), linkedList(9998, 9999, 9999, 9999, 9999, 9999)));
        assertEquals(list(1, 0), formattedSum(linkedList(1), linkedList(9999)));
        assertEquals(list(1000), formattedSum(linkedList(1), linkedList(999)));
        assertEquals(list(1, 0, 0, 0, 0, 0, 0), formattedSum(linkedList(1), linkedList(9999, 9999, 9999, 9999, 9999, 9999)));
        assertEquals(list(8339, 6819), formattedSum(linkedList(8339, 4510), linkedList(2309)));
        assertEquals(list(9876, 5434, 0), formattedSum(linkedList(9876, 5432, 1999), linkedList(1, 8001)));
        assertEquals(list(1, 0, 0, 0, 0, 0, 0), formattedSum(linkedList(1), linkedList(9999, 9999, 9999, 9999, 9999, 9999)));
        assertEquals(list(1, 0), formattedSum(linkedList(1), linkedList(9999)));
        assertEquals(list(1000), formattedSum(linkedList(1), linkedList(999)));
    }

    @Test
    public void zzz(){
        assertEquals(list(9876, 5434, 0), formattedSum(linkedList(9876, 5432, 1999), linkedList(1, 8001)));
    }

    @Test
    public void removeLeadingZeroesTests() {
        assertEquals(linkedList(1), removeLeadingZeroes(linkedList(0, 0, 0, 1)));
        assertEquals(linkedList(11), removeLeadingZeroes(linkedList(0, 0, 1, 1)));
        assertEquals(linkedList(9, 1), removeLeadingZeroes(linkedList(9, 0, 0, 0, 1)));
    }

    @Test
    public void concatIntsTests() {
        assertEquals(123, concatInt(1, 2, 3));
        assertEquals(13, concatInt(1, 3));
        assertEquals(3, concatInt(3));
        assertEquals(54563, concatInt(5, 4, 5, 6, 3));
    }


}
