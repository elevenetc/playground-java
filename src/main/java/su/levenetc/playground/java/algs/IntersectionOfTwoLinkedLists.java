package su.levenetc.playground.java.algs;

import java.util.Deque;
import java.util.LinkedList;

import su.levenetc.playground.java.datastructures.IntNode;

public class IntersectionOfTwoLinkedLists {

    static IntNode getMem(IntNode listA, IntNode listB) {
        Deque<IntNode> stackA = fillStack(listA);
        Deque<IntNode> stackB = fillStack(listB);
        IntNode intersection = null;

        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            IntNode nodeA = stackA.pop();
            IntNode nodeB = stackB.pop();

            if (nodeA == nodeB) {
                intersection = nodeA;
            }
        }

        return intersection;
    }

    private static Deque<IntNode> fillStack(IntNode node) {
        Deque<IntNode> result = new LinkedList<>();
        while (node != null) {
            result.push(node);
            node = node.next;
        }
        return result;
    }

    static IntNode getWithoutMem(IntNode listA, IntNode listB) {

        ListData dataA = length(listA);
        ListData dataB = length(listB);

        if (dataA.last != dataB.last) return null;

        IntNode longer;
        IntNode shorter;
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

    private static IntNode getKthNode(IntNode node, int k) {
        while (k != 0) {
            node = node.next;
            k--;
        }
        return node;
    }

    private static ListData length(IntNode node) {
        int length = 0;
        IntNode last = null;
        while (node != null) {
            length++;
            last = node;
            node = node.next;
        }
        return new ListData(length, last);
    }

    static class ListData {
        int length;
        IntNode last;

        public ListData(int length, IntNode last) {
            this.length = length;
            this.last = last;
        }
    }
}
