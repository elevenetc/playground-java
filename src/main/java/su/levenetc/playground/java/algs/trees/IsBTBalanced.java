package su.levenetc.playground.java.algs.trees;

import su.levenetc.playground.java.datastructures.BNode;

public class IsBTBalanced {

    public static boolean isBalanced(BNode node) {
        return internal(node) != -1;
    }

    private static int internal(BNode node) {
        if (node == null) return 0;

        int left = internal(node.left);
        int right = internal(node.right);

        if (left == -1 || right == -1) return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
