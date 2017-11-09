package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.IntNode;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.LinkedListLoopDetection.hasLoop;
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
        IntNode node1 = node(1);
        IntNode node2 = node(2);
        IntNode node3 = node(3);
        IntNode node4 = node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        assertTrue(hasLoop(node1));
    }

}
