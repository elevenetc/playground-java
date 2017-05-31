import org.junit.Test;

import su.levenetc.playground.java.datastructures.BitSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by eugene.levenetc on 31/05/2017.
 */
public class TestBitSet {
    @Test
    public void test01() {
        BitSet bitSet = new BitSet();
        bitSet.add(1);
        assertTrue(bitSet.contains(1));
        assertFalse(bitSet.contains(0));
        bitSet.add(10);
        assertTrue(bitSet.contains(10));
    }
}
