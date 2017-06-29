import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.LinkedListPalindrome.getList;
import static su.levenetc.playground.java.algs.LinkedListPalindrome.isListPalindrome;

/**
 * Created by eugene.levenetc on 29/06/2017.
 */
public class TestLinkedListPalindrome {
    @Test
    public void test01() {
        assertFalse(isListPalindrome(getList(1, 2, 3, 4)));
    }

    @Test
    public void test02() {
        assertTrue(isListPalindrome(getList(1, 2, 2, 1)));
    }
}
