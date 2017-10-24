import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.AllPermutationsInsideString.checkInclusion;
import static su.levenetc.playground.java.algs.AllPermutationsInsideString.get;

public class AllPermutationsInsideStringTests {
    @Test
    public void test01() {
        List<Integer> indexes = get("ab", "abba");
        assertTrue(indexes.indexOf(0) > -1);
        assertTrue(indexes.indexOf(2) > -1);
    }

    @Test
    public void test02() {
        List<Integer> indexes = get("abc", "_cab_babc");
        assertTrue(indexes.indexOf(1) > -1);
        assertTrue(indexes.indexOf(5) > -1);
    }

    @Test
    public void testInclusion01() {
        assertTrue(checkInclusion("abc", "aabca"));
        assertTrue(checkInclusion("abc", "abc"));
        assertTrue(checkInclusion("abc", "xabc"));
        assertTrue(checkInclusion("abc", "abcx"));
        assertFalse(checkInclusion("abc", "abxba"));
    }
}