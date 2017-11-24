package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.ListNode;

public class DeleteSingleLinkedListNode {
    static void delete(ListNode node) {
        if (node == null || node.next == null) return;
        ListNode current = node;
        ListNode next = node.next;
        while (next != null) {
            current.value = next.value;

            if (next.next == null) {
                current.next = null;
                return;
            }

            current = next;
            next = current.next;
        }
    }
}
