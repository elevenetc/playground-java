package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.LongestIncreasingSubsequence.get;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void test() throws Exception {
        assertEquals(3, get(1, 2, 3, 0));
        assertEquals(4, get(1, 2, 3, 0, 1, 2, 3));
        assertEquals(3, get(2, 1, 30, 10, 1, 2, 3, 2, 1));
    }

}