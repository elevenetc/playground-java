package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.IntNode;

public class LinkedListLoopDetection {

    static boolean loopStartNode(IntNode list) {
        return false;
    }

    static boolean hasLoop(IntNode list) {
        if (list == null || list.next == null) return false;
        IntNode slow = list;
        IntNode fast = list;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        return fast != null && fast.next != null;
    }
}
