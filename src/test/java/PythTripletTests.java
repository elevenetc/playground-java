import org.junit.Test;

import su.levenetc.playground.java.algs.PythTriplet;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by eugene.levenetc on 11/06/2017.
 */
public class PythTripletTests {
    @Test
    public void test01() {
        assertArrayEquals(new int[]{5, 12, 13}, PythTriplet.get(5));
        assertArrayEquals(new int[]{29, 420, 421}, PythTriplet.get(29));
        assertArrayEquals(new int[]{31, 480, 481}, PythTriplet.get(31));
        assertArrayEquals(new int[]{64, 1023, 1025}, PythTriplet.get(64));
    }
}
