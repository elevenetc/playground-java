package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.BitOps.byteToInt;
import static su.levenetc.playground.java.algs.BitOps.intToByte;

public class BitOpsTest {
    @Test
    public void testByteToInt() {
        assertEquals(10, byteToInt(intToByte(10)));
        assertEquals(-10, byteToInt(intToByte(-10)));
        assertEquals(4587, byteToInt(intToByte(4587)));
    }
}
