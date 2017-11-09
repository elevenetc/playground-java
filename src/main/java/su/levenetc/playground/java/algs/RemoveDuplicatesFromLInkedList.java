package su.levenetc.playground.java.algs;

import java.util.HashSet;
import java.util.Set;

import su.levenetc.playground.java.datastructures.IntNode;

public class RemoveDuplicatesFromLInkedList {
    static IntNode remove(IntNode node) {
        IntNode root = node;
        Set<Integer> set = new HashSet<>();
        IntNode prev = null;
        while (node != null) {
            if (set.contains(node.value)) {
                prev.next = node.next;
            } else {
                set.add(node.value);
            }
            prev = node;
            node = node.next;
        }
        return root;
    }
}
