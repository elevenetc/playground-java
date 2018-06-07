package su.levenetc.playground.java.algs.graphs;

import su.levenetc.playground.java.datastructures.BNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InOrderInterative {
    public static List<Integer> get(BNode root) {

        List<Integer> result = new LinkedList<>();
        Deque<BNode> stack = new LinkedList<>();

        BNode node = root;

        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            BNode n = stack.pop();
            result.add(n.value);

            if (n.right != null) {
                BNode right = n.right;
                while (right != null) {
                    stack.push(right);
                    right = right.left;
                }
            }
        }

        return result;
    }
}
