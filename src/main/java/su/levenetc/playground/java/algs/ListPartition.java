package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.LNode;

public class ListPartition {
    public static LNode partition(LNode head, int x) {

        if (head == null || head.next == null) return head;

        LNode leftHead = null;
        LNode left = null;
        LNode rightHead = null;
        LNode right = null;

        LNode node = head;

        while (node != null) {
            if (node.value < x) {
                if (leftHead == null) {
                    leftHead = node;
                    left = node;
                } else {
                    left.next = node;
                    left = node;
                }
            } else if (node.value >= x) {
                if (rightHead == null) {
                    rightHead = node;
                    right = node;
                } else {
                    right.next = node;
                    right = node;
                }
            }

            node = node.next;
        }

        if (left == null || right == null) {
            return head;
        } else {
            left.next = rightHead;
            right.next = null;
            return leftHead;
        }
    }
}
