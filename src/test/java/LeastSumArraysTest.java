import org.junit.Test;

import su.levenetc.playground.java.algs.LeastSumArrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 14/06/2017.
 */
public class LeastSumArraysTest {
    @Test
    public void test0() {
        assertEquals(2, LeastSumArrays.get(new int[]{1, 6, 3}, new int[]{5, 3, 1}));
    }

    @Test
    public void test1() {
        assertEquals(102, LeastSumArrays.get(new int[]{10, 1}, new int[]{101, 100}));
    }

    @Test
    public void test3() {
        assertEquals(3, LeastSumArrays.get(new int[]{1, 2, 5}, new int[]{1, 6, 3}));
    }

    @Test
    public void test4() {
        assertEquals(11, LeastSumArrays.get(new int[]{10, 1}, new int[]{10, 1}));
    }

    @Test
    public void test5() {
        assertEquals(2, LeastSumArrays.get(new int[]{1, 2}, new int[]{2, 1}));
    }
}
