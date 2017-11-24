package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.ListNode;
import su.levenetc.playground.java.utils.Out;

public class LinkedListLoopDetection {

    static ListNode loopStartNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

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

    static boolean hasLoop(ListNode list) {
        if (list == null || list.next == null) return false;
        ListNode slow = list;
        ListNode fast = list;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        return fast != null && fast.next != null;
    }

    static ListNode findLoopCollisionNode(ListNode list) {
        ListNode slow = list;
        ListNode fast = list;


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
