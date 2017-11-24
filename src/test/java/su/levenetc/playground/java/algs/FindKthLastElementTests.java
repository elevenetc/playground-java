package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.ListNode;

import static su.levenetc.playground.java.algs.FindKthLastElement.findIterative;
import static su.levenetc.playground.java.algs.FindKthLastElement.findRecursive;
import static su.levenetc.playground.java.datastructures.ListNode.list;
import static su.levenetc.playground.java.utils.TestUtils.assertEquals;

public class FindKthLastElementTests {
    @Test
    public void testRecursive() {
        ListNode root = list(100, 200, 300);
        assertEquals(200, (findRecursive(2, root)));
        assertEquals(300, (findRecursive(1, root)));
        assertEquals(-1, (findRecursive(100, root)));
    }

    @Test
    public void testIterative() {
        ListNode root = list(100, 200, 300);
        assertEquals(200, (findIterative(2, root)));
        assertEquals(300, (findIterative(1, root)));
        assertEquals(-1, (findIterative(100, root)));
    }
}
