package su.levenetc.playground.java.algs;

import org.junit.Test;

import static su.levenetc.playground.java.utils.TestUtils.assertEquals;

public class UrilifyTests {
    @Test
    public void test01() {
        assertEquals("a%20b", Urilify.get0("a b  "));
        assertEquals("a%20", Urilify.get0("a  "));
        assertEquals("%20a", Urilify.get0(" a "));
        assertEquals("a%20b%20c", Urilify.get0("a b c   "));
    }
}
