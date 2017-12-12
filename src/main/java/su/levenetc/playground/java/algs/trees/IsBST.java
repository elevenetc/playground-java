package su.levenetc.playground.java.algs.trees;

import su.levenetc.playground.java.datastructures.BNode;

public class IsBST {
    public static boolean is(BNode mid) {
        return is(mid, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean is(BNode mid, int min, int max) {
        if (mid == null) return true;

        if (mid.value > max || mid.value < min) {
            return false;
        } else {
            return is(mid.left, min, mid.value) && is(mid.right, mid.value, max);
        }
    }

}
