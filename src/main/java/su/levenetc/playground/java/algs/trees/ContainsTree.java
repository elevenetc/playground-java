package su.levenetc.playground.java.algs.trees;

import su.levenetc.playground.java.datastructures.BNode;

public class ContainsTree {

    public static boolean contains1(BNode deep, BNode shallow) {
        BNode f = find(deep, shallow);

        if (f == null) return false;

        return equals(f, shallow);
    }

    private static BNode find(BNode tree, BNode node) {
        if (tree == null) return null;
        if (tree.value == node.value) {
            return tree;
        }
        BNode left = find(tree.left, node);

        if (left != null) return left;

        BNode right = find(tree.right, node);

        return right;
    }

    private static boolean equals(BNode a, BNode b) {

        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.value != b.value) return false;

        return equals(a.left, b.left) && equals(a.right, b.right);
    }

    public static boolean contains2(BNode deep, BNode shallow) {
        String deepString = buildString(deep);
        String shallowString = buildString(shallow);
        return deepString.contains(shallowString);
    }

    public static String buildString(BNode node) {
        return buildString(node, new StringBuilder()).toString();
    }

    public static StringBuilder buildString(BNode node, StringBuilder sb) {
        if (node == null) return sb;

        buildString(node.left, sb);

        sb.append('|');
        sb.append(node.value);
        sb.append('|');

        buildString(node.right, sb);

        return sb;
    }
}
