package su.levenetc.playground.java.algs.trees;

import su.levenetc.playground.java.datastructures.BNode;

public class DepthOfTree {
    public static int min(BNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;

        int left = min(node.left);
        int right = min(node.right);

        if (left == 0) {
            return right + 1;
        } else if (right == 0) {
            return left + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    public static int max(BNode node) {
        if (node == null) return 0;
        return Math.max(max(node.left), max(node.right)) + 1;
    }
}
