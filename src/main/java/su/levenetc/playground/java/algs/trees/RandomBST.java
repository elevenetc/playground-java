package su.levenetc.playground.java.algs.trees;

public class RandomBST {

    Node root;

    public void insert(int value) {

        if (root == null) {
            root = new Node(value);
            return;
        }

        Node curr = root;
        while (true) {
            curr.size++;
            if (value <= curr.value) {
                if (curr.left == null) {
                    curr.left = new Node(value);
                    return;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = new Node(value);
                    return;
                } else {
                    curr = curr.right;
                }
            }
        }
    }

    public Node find(int value) {
        Node curr = root;
        while (curr != null) {
            if (value == curr.value) {
                return curr;
            } else if (value < curr.value) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }

    public Node getRandomNode() {
        if (root == null) return null;
        //int rnd = (int) (Math.random() * root.size);
        int rnd = 4;
        return getRandomNode(root, rnd);
    }

    private Node getRandomNode(Node node, int num) {
        int leftSize = (node.left == null) ? 0 : node.left.size;
        if (num < leftSize) {
            return getRandomNode(node.left, num);
        } else if (num == leftSize) {
            return node;
        } else {
            return getRandomNode(node.right, num - leftSize - 1);
        }
    }

    static class Node {

        Node left;
        Node right;
        int value;
        int size = 1;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("(v:%d s:%d)", value, size);
        }
    }
}
