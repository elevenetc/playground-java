package su.levenetc.playground.java.datastructures;

/**
 * Created by eugene.levenetc on 08/02/2017.
 */
public class BT {

    Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            internalAdd(root, value);
        }
    }

    public Node getRoot() {
        return root;
    }

    private void internalAdd(Node node, int value) {

        if (node.left != null && value < node.left.value) {
            internalAdd(node.left, value);
            return;
        } else if (node.right != null && value > node.right.value) {
            internalAdd(node.right, value);
            return;
        }

        if (value > node.value) {
            node.right = new Node(value);
        } else if (value < node.value) {
            node.left = new Node(value);
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
