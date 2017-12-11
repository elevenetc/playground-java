package su.levenetc.playground.java.algs;

import java.util.Deque;
import java.util.LinkedList;

import su.levenetc.playground.java.datastructures.LNode;

public class IntersectionOfTwoLinkedLists {

    static LNode getMem(LNode listA, LNode listB) {
        Deque<LNode> stackA = fillStack(listA);
        Deque<LNode> stackB = fillStack(listB);
        LNode intersection = null;

        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            LNode nodeA = stackA.pop();
            LNode nodeB = stackB.pop();

            if (nodeA == nodeB) {
                intersection = nodeA;
            }
        }

        return intersection;
    }

    private static Deque<LNode> fillStack(LNode node) {
        Deque<LNode> result = new LinkedList<>();
        while (node != null) {
            result.push(node);
            node = node.next;
        }
        return result;
    }

    static LNode getWithoutMem(LNode listA, LNode listB) {

        ListData dataA = length(listA);
        ListData dataB = length(listB);

        if (dataA.last != dataB.last) return null;

        LNode longer;
        LNode shorter;
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

    private static LNode getKthNode(LNode node, int k) {
        while (k != 0) {
            node = node.next;
            k--;
        }
        return node;
    }

    private static ListData length(LNode node) {
        int length = 0;
        LNode last = null;
        while (node != null) {
            length++;
            last = node;
            node = node.next;
        }
        return new ListData(length, last);
    }

    static class ListData {
        int length;
        LNode last;

        public ListData(int length, LNode last) {
            this.length = length;
            this.last = last;
        }
    }
}
