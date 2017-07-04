import org.junit.Test;

import su.levenetc.playground.java.algs.GetBitsCount;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 04/07/2017.
 */
public class GetBitsCountTests {
    @Test
    public void test01() {
        assertEquals(3, GetBitsCount.bitCount(0b111));
        assertEquals(4, GetBitsCount.bitCount(0b1111));
        assertEquals(5, GetBitsCount.bitCount(0b101111));
        assertEquals(0, GetBitsCount.bitCount(0b0));
        assertEquals(1, GetBitsCount.bitCount(0b100000));
    }
}
