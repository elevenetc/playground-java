package su.levenetc.playground.java.algs;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.IsPermutationOfPalindrome.get;

public class IsPermutationOfPalindromeTests {
    @Test
    public void test01() {
        assertTrue(get("Tact Coa"));
        assertTrue(get("Rats live on no evil star"));
        assertFalse(get("Rats live on no evil starXZ"));
    }
}
