package su.levenetc.playground.java.algs.trees;

import su.levenetc.playground.java.datastructures.BNode;

public class DepthOfTree {
    public static int min(BNode node) {
        if (node == null) return 0;
        int left = min(node.left);
        int right = min(node.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    public static int max(BNode node) {
        if (node == null) return 0;
        return Math.max(max(node.left), max(node.right)) + 1;
    }
}
