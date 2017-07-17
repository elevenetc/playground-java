import org.junit.Test;

import su.levenetc.playground.java.algs.IsIsomorphic;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by eugene.levenetc on 18/07/2017.
 */
public class IsIsomorphicTests {
    @Test
    public void test01() {
        assertTrue(IsIsomorphic.is("abb", "cxx"));
    }

    @Test
    public void test02() {
        assertFalse(IsIsomorphic.is("abb", "cbx"));
    }

    @Test
    public void test03() {
        assertTrue(IsIsomorphic.is("paper", "title"));
    }
}
