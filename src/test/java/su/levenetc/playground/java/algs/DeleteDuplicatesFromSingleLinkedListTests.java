package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.ListNode;

import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.DeleteDuplicatesFromSingleLinkedList.removeDuplicatesFree;
import static su.levenetc.playground.java.algs.DeleteDuplicatesFromSingleLinkedList.removeDuplicatesMem;
import static su.levenetc.playground.java.datastructures.ListNode.list;

public class DeleteDuplicatesFromSingleLinkedListTests {
    @Test
    public void test01() {
        ListNode list = list(1, 2, 3);
        assertTrue(list(1, 2, 3).valueEquals(removeDuplicatesFree(list)));
        assertTrue(list(1, 2, 3).valueEquals(removeDuplicatesMem(list)));
    }

    @Test
    public void test02() {
        assertTrue(list(1, 2, 3).valueEquals(removeDuplicatesFree(list(1, 2, 2, 3))));
        assertTrue(list(1, 2, 3).valueEquals(removeDuplicatesMem(list(1, 2, 2, 3))));
    }

}
