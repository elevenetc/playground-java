package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.ListNode;

public class MergeTwoLinkedLists {
    static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;


        ListNode result = null;
        ListNode node = null;
        while (l1 != null && l2 != null) {
            int value;
            if (l1.value < l2.value) {
                value = l1.value;
                l1 = l1.next;
            } else {
                value = l2.value;
                l2 = l2.next;
            }
            if (result == null) {
                result = new ListNode(value);
                node = result;
            } else {
                node.next = new ListNode(value);
                node = node.next;
            }
        }

        ListNode rest = null;

        if (l1 != null) {
            rest = l1;
        } else if (l2 != null) {
            rest = l2;
        }

        node.next = rest;

        return result;
    }
}
