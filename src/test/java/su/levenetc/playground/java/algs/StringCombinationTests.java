package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.StringCombination.get;
import static su.levenetc.playground.java.utils.Utils.set;

public class StringCombinationTests {
    @Test
    public void test() {
        assertEquals(set("a", "ab", "bc", "ac", "b", "abc", "c"), get("abc"));
        assertEquals(set("a", "aa", "aaa"), get("aaa"));
    }
}
