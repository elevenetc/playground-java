package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.MergeTwoLinkedLists.merge;
import static su.levenetc.playground.java.datastructures.ListNode.list;

public class MergeTwoLinkedListsTests {
    @Test
    public void test() {
        assertEquals(list(0, 5, 10, 100, 150), merge(list(0, 10, 100), list(5, 60, 150)));
    }
}
