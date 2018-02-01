package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.LNode;

import static su.levenetc.playground.java.algs.IntersectionOfTwoLinkedLists.getMem;
import static su.levenetc.playground.java.algs.IntersectionOfTwoLinkedLists.getWithoutMem;
import static su.levenetc.playground.java.utils.TestUtils.assertEquals;

public class IntersectionOfTwoLinkedListsTests {
    @Test
    public void test01() {
        LNode listA = LNode.list(0, 1, 2);
        LNode listB = LNode.list(0, 1, 2);
        LNode interNode = new LNode(100);
        listA.next = interNode;
        listB.next = interNode;
        interNode.next = new LNode(200);
        assertEquals(interNode, getMem(listA, listB));
        assertEquals(interNode, getWithoutMem(listA, listB));
        assertEquals(interNode, intersection(listA, listB));
    }

    @Test
    public void test02() {
        LNode listA = LNode.list(0, 1, 2);
        LNode listB = LNode.list(0, 1, 2);
        assertEquals(null, getMem(listA, listB));
        assertEquals(null, getWithoutMem(listA, listB));
        assertEquals(null, intersection(listA, listB));
    }

    static LNode intersection(LNode listA, LNode listB) {
        int sizeA = listA.size();
        int sizeB = listB.size();

        if (sizeA > sizeB) {
            listA = cut(listA, sizeA - sizeB);
        } else if (sizeB > sizeA) {
            listB = cut(listB, sizeB - sizeA);
        }

        while (listA != listB) {
            listA = listA.next;
            listB = listB.next;
        }
        return listA;
    }

    static LNode cut(LNode list, int diff) {
        while (diff != 0) {
            list = list.next;
            diff--;
        }
        return list;
    }

}
