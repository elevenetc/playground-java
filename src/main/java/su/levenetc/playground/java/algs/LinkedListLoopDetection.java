package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.LNode;
import su.levenetc.playground.java.utils.Out;

public class LinkedListLoopDetection {

    static LNode loopStartNode(LNode head) {
        LNode slow = head;
        LNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    static boolean hasLoop(LNode list) {
        if (list == null || list.next == null) return false;
        LNode slow = list;
        LNode fast = list;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        return fast != null && fast.next != null;
    }

    static LNode findLoopCollisionNode(LNode list) {
        LNode slow = list;
        LNode fast = list;


        Out.pln("start...");

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            Out.pln("loop...");

            if (fast == slow) {
                Out.pln("found");
                return fast;
            }
        }

        return null;
    }
}
