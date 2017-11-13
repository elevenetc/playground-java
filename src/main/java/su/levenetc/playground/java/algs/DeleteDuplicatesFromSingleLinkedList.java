package su.levenetc.playground.java.algs;

import java.util.HashSet;
import java.util.Set;

import su.levenetc.playground.java.datastructures.IntNode;

public class DeleteDuplicatesFromSingleLinkedList {
    public static IntNode removeDuplicatesFree(IntNode list) {
        IntNode current = list;

        while (current != null) {
            findAndDelete(current, current.value);
            current = current.next;
        }
        return list;
    }

    private static void findAndDelete(IntNode list, int value) {
        IntNode prev = null;
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

    public static IntNode removeDuplicatesMem(IntNode list) {
        Set<Integer> mem = new HashSet<>();
        IntNode node = list;
        IntNode prev = null;
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

    private static void deleteNode(IntNode prev, IntNode del) {
        prev.next = del.next;
    }
}
