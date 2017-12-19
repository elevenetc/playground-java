package su.levenetc.playground.java.algs;

import java.util.HashSet;
import java.util.Set;

import su.levenetc.playground.java.datastructures.LNode;

public class RemoveDuplicates {
    public static LNode removeDuplicatesFree(LNode list) {
        LNode current = list;

        while (current != null) {
            findAndDelete(current, current.value);
            current = current.next;
        }
        return list;
    }

    private static void findAndDelete(LNode list, int value) {
        LNode prev = null;
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

    public static LNode removeDuplicatesMem(LNode list) {
        Set<Integer> mem = new HashSet<>();
        LNode node = list;
        LNode prev = null;
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

    private static void deleteNode(LNode prev, LNode del) {
        prev.next = del.next;
    }
}
