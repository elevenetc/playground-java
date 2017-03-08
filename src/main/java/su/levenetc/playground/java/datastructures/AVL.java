package su.levenetc.playground.java.datastructures;

/**
 * Created by eugene.levenetc on 14/02/2017.
 */
public class AVL {

    private Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node newNode = internalAdd(value, root);
            balance(newNode.parent);
        }
    }

    private void balance(Node node) {
        if (node == null) return;

        if (node.isBalanced()) {
            node.depth++;
            balance(node.parent);
        } else {
            if (node.rightDepth() == 0) {
                Node topParent = node.parent;
                Node newTop = node.left;
                Node newLeft = node.left.left;
                Node newRight = node;

                newTop.parent = topParent;

                if (topParent != null) {
                    topParent.left = newTop;
                }

                newTop.left = newLeft;
                newTop.right = newRight;
                newLeft.parent = newTop;
                newRight.parent = newTop;

                newRight.depth = 0;

                balance(newTop.parent);

            }
        }
    }

    private void rotateLeftLeft() {

    }

    private void rotateRightRight() {

    }

    private int depth(Node node) {
        return node == null ? 0 : node.depth;
    }

    private Node internalAdd(int value, Node node) {
        Node newNode = null;
        if (value > node.value) {
            if (node.right == null) {
                node.right = new Node(value);
                node.right.parent = node;
                newNode = node.right;
            } else {
                internalAdd(value, node.right);
            }
        } else if (value < node.value) {
            if (node.left == null) {
                node.left = new Node(value);
                node.left.parent = node;
                newNode = node.left;
            } else {
                internalAdd(value, node.left);
            }
        }
        return newNode;
    }

    public static class Node {

        Node left;
        Node right;
        Node parent;

        int depth;

        int value;

        Node(int value) {
            this.value = value;
        }

        int leftDepth() {
            return left == null ? 0 : left.depth;
        }

        int rightDepth() {
            return right == null ? 0 : right.depth;
        }

        boolean isBalanced() {
            return Math.abs(leftDepth() - rightDepth()) <= 0;
        }

        boolean hasNoChildren() {
            return left == null && right == null;
        }
    }
}
