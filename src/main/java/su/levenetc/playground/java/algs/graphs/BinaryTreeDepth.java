package su.levenetc.playground.java.algs.graphs;

import java.util.LinkedList;
import java.util.Queue;

import su.levenetc.playground.java.datastructures.BNode;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class BinaryTreeDepth {

    public static int maxRecursive(BNode root) {
        return maxRecursive(root, 0);
    }

    private static int maxRecursive(BNode root, int max) {
        if (root == null) return max;
        max++;
        return max(maxRecursive(root.left, max), maxRecursive(root.right, max));
    }

    public static int maxIterative(BNode root) {
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

    public static int minIterative(BNode root) {
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

                if (poll.left == null && poll.right == null) {
                    return result;
                }

                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
            }
        }
        return result;
    }

    public static int minRecursive(BNode root) {
        return minRecursive(root, 0);
    }

    private static int minRecursive(BNode root, int m) {
        if (root == null) return m;
        m++;
        return min(minRecursive(root.left, m), minRecursive(root.right, m));
    }
}
