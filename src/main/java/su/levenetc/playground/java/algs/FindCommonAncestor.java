package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.BNode;

public class FindCommonAncestor {

    public static BNode withoutParent(BNode root, BNode a, BNode b) {
        if (root == null) {
            return null;
        } else if (root == a) {
            return a;
        } else if (root == b) {
            return b;
        } else {
            BNode left = withoutParent(root.left, a, b);
            BNode right = withoutParent(root.right, a, b);

            if ((left == a && right == b) || (left == b && right == a)) {
                //found
                return root;
            } else {
                return left == null ? right : left;
            }
        }
    }

    public static BNode withParent(BNode nA, BNode nB) {

        int depthA = depth(nA);
        int depthB = depth(nB);

        if (depthA > depthB) {
            nA = cut(nA, depthA - depthB);
        } else if (depthB > depthA) {
            nB = cut(nA, depthB - depthA);
        }

        while (nA != nB) {
            nA = nA.parent;
            nB = nB.parent;
        }
        return nA;
    }

    static BNode cut(BNode node, int size) {
        while (size != 0) {
            node = node.parent;
            size--;
        }
        return node;
    }

    static int depth(BNode node) {
        if (node == null) {
            return 0;
        } else {
            return depth(node.parent) + 1;
        }
    }
}
