package su.levenetc.playground.java.algs.graphs;

import java.util.LinkedList;
import java.util.Queue;

import su.levenetc.playground.java.datastructures.BNode;

import static java.lang.Math.max;

public class BinaryTreeDepth {

    public static int recursive(BNode root) {
        return recursive(root, 0);
    }

    private static int recursive(BNode root, int max) {
        if (root == null) return max;
        max++;
        return max(recursive(root.left, max), recursive(root.right, max));
    }

    public static int iterative(BNode root) {
        Queue<BNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int result = 0;
        while (!queue.isEmpty()) {
            BNode poll = queue.poll();
            if (poll == null) {
                result++;
                if (!queue.isEmpty()) queue.offer(null);
            } else {
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return result;
    }
}
