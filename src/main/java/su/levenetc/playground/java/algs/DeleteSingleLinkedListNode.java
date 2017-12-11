package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.LNode;

public class DeleteSingleLinkedListNode {
    static void delete(LNode node) {
        if (node == null || node.next == null) return;
        LNode current = node;
        LNode next = node.next;
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
