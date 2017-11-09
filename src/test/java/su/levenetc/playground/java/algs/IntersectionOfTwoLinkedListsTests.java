package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.IntNode;

import static su.levenetc.playground.java.algs.IntersectionOfTwoLinkedLists.getMem;
import static su.levenetc.playground.java.algs.IntersectionOfTwoLinkedLists.getWithoutMem;
import static su.levenetc.playground.java.utils.TestUtils.assertEquals;

public class IntersectionOfTwoLinkedListsTests {
    @Test
    public void test01() {
        IntNode listA = IntNode.list(0, 1, 2);
        IntNode listB = IntNode.list(0, 1, 2);
        IntNode interNode = new IntNode(100);
        listA.next = interNode;
        listB.next = interNode;
        interNode.next = new IntNode(200);
        assertEquals(interNode, getMem(listA, listB));
        assertEquals(interNode, getWithoutMem(listA, listB));
    }

    @Test
    public void test02() {
        IntNode listA = IntNode.list(0, 1, 2);
        IntNode listB = IntNode.list(0, 1, 2);
        assertEquals(null, getMem(listA, listB));
        assertEquals(null, getWithoutMem(listA, listB));
    }

}
