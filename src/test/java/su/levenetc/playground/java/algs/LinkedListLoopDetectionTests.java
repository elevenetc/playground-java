package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.ListNode;
import su.levenetc.playground.java.utils.Out;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.LinkedListLoopDetection.findLoopCollisionNode;
import static su.levenetc.playground.java.algs.LinkedListLoopDetection.hasLoop;
import static su.levenetc.playground.java.algs.LinkedListLoopDetection.loopStartNode;
import static su.levenetc.playground.java.datastructures.ListNode.list;
import static su.levenetc.playground.java.datastructures.ListNode.node;

public class LinkedListLoopDetectionTests {
    @Test
    public void hasLoop01() {
        ListNode list = list(1, 2, 3, 4, 5);
        assertFalse(hasLoop(list));
    }

    @Test
    public void hasLoop02() {
        ListNode head = node(1);
        ListNode node2 = node(2);
        ListNode node3 = node(3);
        ListNode node4 = node(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = head;

        assertTrue(hasLoop(head));

        Out.pln(findLoopCollisionNode(head));
    }

    @Test
    public void getLoopedNode01() {
        ListNode head = node(1);
        ListNode node2 = node(2);
        ListNode node3 = node(3);
        ListNode node4 = node(4);
        ListNode node5 = node(4);
        ListNode node6 = node(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;


        assertEquals(node3, loopStartNode(head));
    }

    @Test
    public void detectLoop() {
        ListNode head = node(1);
        ListNode node2 = node(2);
        ListNode node3 = node(3);
        ListNode node4 = node(5);
        ListNode tail = node(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = tail;
        tail.next = head;

        Out.pln(findLoopCollisionNode(head));
    }

}
