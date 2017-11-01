package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.ThreeTypesOfEdits.isValidEdit;

public class ThreeTypesOfEditsTests {
    @Test
    public void test() {
        assertTrue(isValidEdit("abc", "ab"));
        assertTrue(isValidEdit("abc", "abc"));
        assertTrue(isValidEdit("abz", "abc"));
        assertFalse(isValidEdit("azz", "abc"));
        assertFalse(isValidEdit("azz", "abcxx"));
    }
}
