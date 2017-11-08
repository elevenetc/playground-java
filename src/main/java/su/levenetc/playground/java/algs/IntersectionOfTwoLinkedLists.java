package su.levenetc.playground.java.algs;

import java.util.Deque;
import java.util.LinkedList;

import su.levenetc.playground.java.datastructures.IntNode;

public class IntersectionOfTwoLinkedLists {
    static IntNode get(IntNode listA, IntNode listB) {
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

    static Deque<IntNode> fillStack(IntNode node) {
        Deque<IntNode> result = new LinkedList<>();
        while (node != null) {
            result.push(node);
            node = node.next;
        }
        return result;
    }
}
