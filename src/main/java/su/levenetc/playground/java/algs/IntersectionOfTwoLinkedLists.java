package su.levenetc.playground.java.algs;

import java.util.Deque;
import java.util.LinkedList;

import su.levenetc.playground.java.datastructures.ListNode;

public class IntersectionOfTwoLinkedLists {

    static ListNode getMem(ListNode listA, ListNode listB) {
        Deque<ListNode> stackA = fillStack(listA);
        Deque<ListNode> stackB = fillStack(listB);
        ListNode intersection = null;

        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            ListNode nodeA = stackA.pop();
            ListNode nodeB = stackB.pop();

            if (nodeA == nodeB) {
                intersection = nodeA;
            }
        }

        return intersection;
    }

    private static Deque<ListNode> fillStack(ListNode node) {
        Deque<ListNode> result = new LinkedList<>();
        while (node != null) {
            result.push(node);
            node = node.next;
        }
        return result;
    }

    static ListNode getWithoutMem(ListNode listA, ListNode listB) {

        ListData dataA = length(listA);
        ListData dataB = length(listB);

        if (dataA.last != dataB.last) return null;

        ListNode longer;
        ListNode shorter;
        ListData longData;
        ListData shortData;

        if (dataA.length > dataB.length) {
            longer = listA;
            shorter = listB;
            longData = dataA;
            shortData = dataB;
        } else {
            longer = listB;
            shorter = listA;
            longData = dataB;
            shortData = dataA;
        }

        longer = getKthNode(longer, longData.length - shortData.length);

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;
    }

    private static ListNode getKthNode(ListNode node, int k) {
        while (k != 0) {
            node = node.next;
            k--;
        }
        return node;
    }

    private static ListData length(ListNode node) {
        int length = 0;
        ListNode last = null;
        while (node != null) {
            length++;
            last = node;
            node = node.next;
        }
        return new ListData(length, last);
    }

    static class ListData {
        int length;
        ListNode last;

        public ListData(int length, ListNode last) {
            this.length = length;
            this.last = last;
        }
    }
}
