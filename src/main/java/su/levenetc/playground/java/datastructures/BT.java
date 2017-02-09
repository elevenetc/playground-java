package su.levenetc.playground.java.datastructures;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by eugene.levenetc on 08/02/2017.
 */
public class BT {

    Node root;

    public BT add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            internalAdd(root, value);
        }
        return this;
    }

    public Node getRoot() {
        return root;
    }

    private void internalAdd(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                internalAdd(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                internalAdd(node.right, value);
            }
        }
    }

    public void printPostOrder() {
        printPostOrder(root);
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public int minValue() {
        return minValue(root, root.value);
    }

    public int getDepth() {
        if (root == null) return 0;
        return getDepth(root, 0);
    }

    private int minValue(Node node, int minValue) {
        if (node == null) {
            return minValue;
        } else {
            return minValue(node.left, node.value);
        }
    }

    private void printPostOrder(Node node) {
        if (node.left != null) printPostOrder(node.left);
        if (node.right != null) printPostOrder(node.right);
        Out.pln(node.value);
    }

    private void printInOrder(Node node) {
        if (node.left != null) printInOrder(node.left);
        Out.pln(node.value);
        if (node.right != null) printInOrder(node.right);
    }

    private int getDepth(BT.Node node, int depth) {

        int left = 0;
        int right = 0;

        if (node.left != null) {
            left = getDepth(node.left, ++depth);
        }

        if (node.right != null) {
            right = getDepth(node.right, ++depth);
        }

        if (left == 0 && right == 0) {
            return depth;
        } else {
            return Math.max(left, right);
        }

    }

    public static class Node {

        int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
