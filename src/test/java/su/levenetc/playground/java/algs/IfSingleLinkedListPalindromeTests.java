package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.IfSingleLinkedListPalindrome.check;
import static su.levenetc.playground.java.datastructures.ListNode.list;

public class IfSingleLinkedListPalindromeTests {
    @Test
    public void test() {
        //assertTrue(check(list(1, 0, 1)));
        //assertTrue(check(list(1, 0, 0, 1)));
        assertTrue(check(list(1, 0, 5, 0, 1)));
    }
}
