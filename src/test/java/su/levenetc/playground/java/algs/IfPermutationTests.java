package su.levenetc.playground.java.algs;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.IfPermutations.get0;
import static su.levenetc.playground.java.algs.IfPermutations.get1;

public class IfPermutationTests {
    @Test
    public void test0() {
        assertTrue(get0("abc", "cba"));
        assertTrue(get0("xxx", "xxx"));
        assertTrue(get0("xxxz", "xzxx"));
        assertFalse(get0("xxx", "xzxx"));
        assertFalse(get0("abc", "axb"));
    }

    @Test
    public void test1() {
        assertTrue(get1("abc", "cba"));
        assertTrue(get1("xxx", "xxx"));
        assertTrue(get1("xxxz", "xzxx"));
        assertFalse(get1("xxx", "xzxx"));
        assertFalse(get1("abc", "axb"));
    }

}
