package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.SumWithoutOperators.sum;

public class SumWithoutOperatorsTests {
    @Test
    public void test() {
        assertEquals(25, sum(10, 15));
        assertEquals(3, sum(1, 2));
        assertEquals(16, sum(8, 8));
    }
}
