package su.levenetc.playground.java.datastructures;

public class BTree {
    public BNode root;

    public BTree(BNode root) {
        this.root = root;
    }

    public BNode get(int value) {
        if (root == null) return null;
        return find(root, value);
    }

    private BNode find(BNode node, int value) {
        if (node == null) return null;
        if (node.value == value) return node;

        BNode left = find(node.left, value);

        if (left != null) return left;

        BNode right = find(node.right, value);

        if (right != null) return right;

        return null;
    }
}
