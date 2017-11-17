import org.junit.Test;

import static java.lang.Integer.bitCount;
import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.BitAlgs.bitCountIterative;

/**
 * Created by eugene.levenetc on 04/07/2017.
 */
public class GetBitsCountTests {
    @Test
    public void test01() {
        assertEquals(bitCount(0b111), bitCountIterative(0b111));
        assertEquals(4, bitCountIterative(0b1111));
        assertEquals(5, bitCountIterative(0b101111));
        assertEquals(0, bitCountIterative(0b0));
        assertEquals(1, bitCountIterative(0b100000));
    }
}
