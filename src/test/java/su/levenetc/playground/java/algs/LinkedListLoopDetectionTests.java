package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.IntNode;
import su.levenetc.playground.java.utils.Out;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.LinkedListLoopDetection.findLoopCollisionNode;
import static su.levenetc.playground.java.algs.LinkedListLoopDetection.hasLoop;
import static su.levenetc.playground.java.algs.LinkedListLoopDetection.loopStartNode;
import static su.levenetc.playground.java.datastructures.IntNode.list;
import static su.levenetc.playground.java.datastructures.IntNode.node;

public class LinkedListLoopDetectionTests {
    @Test
    public void hasLoop01() {
        IntNode list = list(1, 2, 3, 4, 5);
        assertFalse(hasLoop(list));
    }

    @Test
    public void hasLoop02() {
        IntNode head = node(1);
        IntNode node2 = node(2);
        IntNode node3 = node(3);
        IntNode node4 = node(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = head;

        assertTrue(hasLoop(head));

        Out.pln(findLoopCollisionNode(head));
    }

    @Test
    public void getLoopedNode01() {
        IntNode head = node(1);
        IntNode node2 = node(2);
        IntNode node3 = node(3);
        IntNode node4 = node(4);
        IntNode node5 = node(4);
        IntNode node6 = node(4);

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
        IntNode head = node(1);
        IntNode node2 = node(2);
        IntNode node3 = node(3);
        IntNode node4 = node(5);
        IntNode tail = node(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = tail;
        tail.next = head;

        Out.pln(findLoopCollisionNode(head));
    }

}
