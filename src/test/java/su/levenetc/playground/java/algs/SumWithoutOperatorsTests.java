package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.SumWithoutOperators.binarySum;
import static su.levenetc.playground.java.algs.SumWithoutOperators.sum;

public class SumWithoutOperatorsTests {

    @Test
    public void binarySumTest() {
        assertEquals("10", binarySum("1", "1"));
        assertEquals("100", binarySum("11", "1"));
        assertEquals("111", binarySum("010", "101"));
        assertEquals("10001101010", binarySum("11101100", "1101111110"));
    }

    @Test
    public void test() {
        assertEquals(25, sum(10, 15));
        assertEquals(3, sum(1, 2));
        assertEquals(16, sum(8, 8));
    }
}
