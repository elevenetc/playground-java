package su.levenetc.playground.java.algs.trees;

import su.levenetc.playground.java.datastructures.BNode;

public class TreeMirrors {
    public static boolean isMirroredTrees(BNode a, BNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.value != b.value) return false;
        else return isMirrored(a.left, b.right) && isMirrored(a.right, b.left);
    }

    public static boolean isMirrored(BNode root) {
        return isMirrored(root.left, root.right);
    }

    public static boolean isMirrored(BNode left, BNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.value != right.value) return false;

        return isMirrored(left.left, right.right) && isMirrored(left.right, right.left);
    }
}
