package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.LNode;

public class MergeTwoLinkedLists {
    static LNode merge(LNode l1, LNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;


        LNode result = null;
        LNode node = null;
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
                result = new LNode(value);
                node = result;
            } else {
                node.next = new LNode(value);
                node = node.next;
            }
        }

        LNode rest = null;

        if (l1 != null) {
            rest = l1;
        } else if (l2 != null) {
            rest = l2;
        }

        node.next = rest;

        return result;
    }
}
