package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.ListNode;

import static su.levenetc.playground.java.algs.IntersectionOfTwoLinkedLists.getMem;
import static su.levenetc.playground.java.algs.IntersectionOfTwoLinkedLists.getWithoutMem;
import static su.levenetc.playground.java.utils.TestUtils.assertEquals;

public class IntersectionOfTwoLinkedListsTests {
    @Test
    public void test01() {
        ListNode listA = ListNode.list(0, 1, 2);
        ListNode listB = ListNode.list(0, 1, 2);
        ListNode interNode = new ListNode(100);
        listA.next = interNode;
        listB.next = interNode;
        interNode.next = new ListNode(200);
        assertEquals(interNode, getMem(listA, listB));
        assertEquals(interNode, getWithoutMem(listA, listB));
    }

    @Test
    public void test02() {
        ListNode listA = ListNode.list(0, 1, 2);
        ListNode listB = ListNode.list(0, 1, 2);
        assertEquals(null, getMem(listA, listB));
        assertEquals(null, getWithoutMem(listA, listB));
    }

}
