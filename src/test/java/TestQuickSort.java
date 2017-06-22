import org.junit.Test;

import su.levenetc.playground.java.algs.QuickSort;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by eugene.levenetc on 17/06/2017.
 */
public class TestQuickSort {
    @Test
    public void test0() {
        assertArrayEquals(new int[]{1, 2, 3}, QuickSort.sort(3, 2, 1));
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[]{-1, 100, 101}, QuickSort.sort(100, -1, 101));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, QuickSort.sort(6, 5, 4, 3, 2, 1));
    }
}
