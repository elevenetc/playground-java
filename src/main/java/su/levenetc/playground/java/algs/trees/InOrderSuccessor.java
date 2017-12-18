package su.levenetc.playground.java.algs.trees;

import su.levenetc.playground.java.datastructures.BNode;

public class InOrderSuccessor {

    public static BNode get(BNode n) {

        if (n == null) return null;

        if (n.parent == null || n.right != null) {
            return leftMostChildFromRight(n.right);
        } else {
            return getFirstRightParent(n);
        }

    }

    private static BNode getFirstRightParent(BNode child) {
        BNode parent = child.parent;

        while (parent != null && parent.left != child) {
            child = parent;
            parent = parent.parent;
        }

        return parent;
    }

    static BNode leftMostChildFromRight(BNode n) {
        if (n == null) return null;
        while (n.left != null) n = n.left;
        return n;
    }
}
