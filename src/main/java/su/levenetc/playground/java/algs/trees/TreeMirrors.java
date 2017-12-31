package su.levenetc.playground.java.algs.trees;

import java.util.LinkedList;
import java.util.Queue;

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

    public static boolean isMirroredIterative(BNode root) {
        Queue<BNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            BNode n1 = q.poll();
            BNode n2 = q.poll();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.value != n2.value) return false;
            q.add(n1.left);
            q.add(n2.right);
            q.add(n1.right);
            q.add(n2.left);
        }
        return true;
    }
}
