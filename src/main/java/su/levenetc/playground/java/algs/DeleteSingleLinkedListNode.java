package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.IntNode;

public class DeleteSingleLinkedListNode {
    static void delete(IntNode node) {
        if (node == null || node.next == null) return;
        IntNode current = node;
        IntNode next = node.next;
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
