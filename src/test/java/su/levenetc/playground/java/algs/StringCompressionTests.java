package su.levenetc.playground.java.algs;

import org.junit.Test;

import static su.levenetc.playground.java.utils.TestUtils.assertEquals;

public class StringCompressionTests {
    @Test
    public void test() {
        assertEquals("a3", StringCompression.get("aaa"));
        assertEquals("aaabbc", StringCompression.get("aaabbc"));
        assertEquals("a3f3x4", StringCompression.get("aaafffxxxx"));
    }
}
