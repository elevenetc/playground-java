package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.IsPalindromeWithDeletedChar.is;

public class IsPalindromeWithDeletedCharTests {
    @Test
    public void test() {
        assertTrue(is("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        assertTrue(is("abaa"));
        assertTrue(is("aabaa"));
        assertTrue(is("aba"));
        assertTrue(is("123_321"));
        assertTrue(is("123_32x1"));
        assertFalse(is("123_32xx1"));
    }
}
