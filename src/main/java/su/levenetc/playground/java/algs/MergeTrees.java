package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.BNode;

public class MergeTrees {
    public static BNode merge(BNode t1, BNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.value += t2.value;

        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);

        return t1;
    }
}
