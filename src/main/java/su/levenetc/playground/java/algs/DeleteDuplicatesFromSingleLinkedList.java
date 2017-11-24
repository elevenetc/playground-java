package su.levenetc.playground.java.algs;

import java.util.HashSet;
import java.util.Set;

import su.levenetc.playground.java.datastructures.ListNode;

public class DeleteDuplicatesFromSingleLinkedList {
    public static ListNode removeDuplicatesFree(ListNode list) {
        ListNode current = list;

        while (current != null) {
            findAndDelete(current, current.value);
            current = current.next;
        }
        return list;
    }

    private static void findAndDelete(ListNode list, int value) {
        ListNode prev = null;
        while (list != null) {
            if (list.value == value) {
                if (prev != null) {
                    prev.next = list.next;
                }
            }
            prev = list;
            list = list.next;
        }
    }

    public static ListNode removeDuplicatesMem(ListNode list) {
        Set<Integer> mem = new HashSet<>();
        ListNode node = list;
        ListNode prev = null;
        while (node != null) {
            if (mem.contains(node.value)) {
                deleteNode(prev, node);
            } else {
                prev = node;
                mem.add(node.value);
            }

            node = node.next;
        }
        return list;
    }

    private static void deleteNode(ListNode prev, ListNode del) {
        prev.next = del.next;
    }
}
