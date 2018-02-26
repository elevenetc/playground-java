package su.levenetc.playground.java.algs.trees;

import su.levenetc.playground.java.datastructures.BNode;

public class TreesEquality {
    public static boolean equals(BNode a, BNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.value != b.value) return false;

        boolean left = equals(a.left, b.left);
        boolean right = equals(a.right, b.right);

        return left && right;
    }
}
