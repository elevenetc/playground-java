package su.levenetc.playground.java.algs.trees;

import java.util.LinkedList;
import java.util.Queue;

import su.levenetc.playground.java.utils.Out;

public class RandomBST {

    Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        Out.p(node.value + ", ");
        printInOrder(node.right);
    }

    public void printByLayers() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node n = q.poll();

            if (n == null) {
                Out.pln();
                if (!q.isEmpty()) q.add(null);
            } else {
                Out.p(n.value);

                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
        }
    }

    public int getRandom() {
        int rnd = (int) (Math.random() * (root.size + 1));
        return getRandom(root, rnd);
    }

    public int getRandom(int rnd) {
        return getRandom(root, rnd);
    }

    private int getRandom(Node node, int rnd) {
        int left = node.left == null ? 0 : (node.left.size + 1);
        if (rnd < left) {
            return getRandom(node.left, rnd);
        } else if (rnd == left) {
            return node.value;
        } else {
            return getRandom(node.right, rnd - left - 1);
        }
    }

    private void insert(Node root, int value) {
        root.size++;
        if (value < root.value) {
            if (root.left == null) root.left = new Node(value);
            else insert(root.left, value);
        } else {
            if (root.right == null) root.right = new Node(value);
            else insert(root.right, value);
        }
    }

    static class Node {

        int value;
        int size;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
