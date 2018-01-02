package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static su.levenetc.playground.java.algs.ShiftZerosBack.shift;
import static su.levenetc.playground.java.utils.Utils.array;

public class ShiftZerosBackTests {
    @Test
    public void test() {
        assertArrayEquals(array(1, 2, 3, 4, 5, 6, 0, 0, 0, 0), shift(1, 2, 0, 3, 0, 4, 5, 0, 0, 6));
        assertArrayEquals(array(1, 2, 3), shift(1, 2, 3));
        assertArrayEquals(array(1, 2, 3, 0), shift(1, 2, 3, 0));
        assertArrayEquals(array(1, 2, 3, 0), shift(1, 2, 3, 0));
        assertArrayEquals(array(2, 3, 4, 0), shift(0, 2, 3, 4));
        assertArrayEquals(array(1, 0), shift(0, 1));
        assertArrayEquals(array(1, 0), shift(1, 0, 3, 0, 0, 4, 0, 6, 0, 9));
    }
}
