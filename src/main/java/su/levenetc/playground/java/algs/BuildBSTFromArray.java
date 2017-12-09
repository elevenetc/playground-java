package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.BNode;

public class BuildBSTFromArray {
    public static BNode buildTree(int[] a) {
        return buildTree(a, 0, a.length - 1);
    }

    static BNode buildTree(int[] a, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;

        BNode cent = new BNode(a[mid]);
        cent.left = buildTree(a, start, mid - 1);
        cent.right = buildTree(a, mid + 1, end);
        return cent;
    }
}
