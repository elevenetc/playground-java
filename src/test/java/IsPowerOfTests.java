import org.junit.Test;

import su.levenetc.playground.java.algs.IsPowerOf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsPowerOfTests {
    @Test
    public void test01() {
        assertTrue(IsPowerOf.two1(64));
        assertTrue(IsPowerOf.two1(1024));
        assertFalse(IsPowerOf.two1(2500));
        assertFalse(IsPowerOf.two1(17));
        assertFalse(IsPowerOf.two1(3458));
        assertFalse(IsPowerOf.two1(9));
    }

    @Test
    public void test02() {
        assertTrue(IsPowerOf.two2(64));
        assertTrue(IsPowerOf.two2(1024));
        assertFalse(IsPowerOf.two2(2500));
        assertFalse(IsPowerOf.two2(17));
        assertFalse(IsPowerOf.two2(3458));
        assertFalse(IsPowerOf.two2(9));
    }

}
