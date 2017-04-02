import org.junit.Test;
import su.levenetc.playground.java.algs.HammingDistance;
import su.levenetc.playground.java.utils.Out;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 02/04/2017.
 */
public class TestHummingDistance {
    @Test
    public void test() {
        Out.plnBin(0b101 & 0b1);
        assertEquals(0, HammingDistance.get(3, 1));
        assertEquals(2, HammingDistance.get(4, 1));
        assertEquals(2, HammingDistance.get(93, 73));
        assertEquals(6, HammingDistance.get(0b10001, 0b1000000));
    }
}
