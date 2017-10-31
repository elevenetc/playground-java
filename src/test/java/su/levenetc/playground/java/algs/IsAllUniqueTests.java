package su.levenetc.playground.java.algs;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.IsAllUnique.getAny;
import static su.levenetc.playground.java.algs.IsAllUnique.getPrintable;

public class IsAllUniqueTests {
    @Test
    public void test01() {
        assertTrue(getAny("abc"));
        assertFalse(getAny("aba"));
        assertFalse(getAny("zzz"));

        assertTrue(getPrintable("abc"));
        assertFalse(getPrintable("aba"));
        assertFalse(getPrintable("zzz"));
    }
}
