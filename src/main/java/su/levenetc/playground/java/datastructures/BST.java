package su.levenetc.playground.java.datastructures;

import su.levenetc.playground.java.utils.Out;

import java.util.*;

/**
 * Created by eugene.levenetc on 08/02/2017.
 */
public class BST {

    Node root;

    public BST add(int value) {
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

    public void clear() {
        root = null;
    }

    private void internalAdd(Node node, int value) {
        if (value < node.value) {
            if (node.left == null) {
                final Node newNode = new Node(value);
                node.left = newNode;
                newNode.parent = node;
            } else {
                internalAdd(node.left, value);
            }
        } else {
            if (node.right == null) {
                final Node newNode = new Node(value);
                node.right = newNode;
                newNode.parent = node;
            } else {
                internalAdd(node.right, value);
            }
        }
    }

    public void getRange(int min, int max) {

    }

    public Node find(int value) {
        return internalFind(root, value);
    }

    private Node internalFind(Node node, int value) {

        if (node == null) {
            return null;
        } else if (node.value == value) {
            return node;
        }

        if (value > node.value) {
            return internalFind(node.right, value);
        } else {
            return internalFind(node.left, value);
        }
    }

    public void printAllPaths() {
        findPath(root, new ArrayList<>(1000), 0);
    }

    private void findPath(Node node, List<Integer> steps, int step) {

        if (node == null) return;

        steps.add(step, node.value);
        step++;

        if (node.left == null && node.right == null) {
            Out.p("Path: ");
            for (int i = 0; i < step; i++) {
                Out.p(steps.get(i));
            }
            Out.pln();
        } else {
            findPath(node.left, steps, step);
            findPath(node.right, steps, step);
        }
    }

    public void mirror() {
        internalMirror(root);
    }

    public boolean isEqual(BST BST) {
        return isEqualInternal(root, BST.getRoot());
    }

    private boolean isEqualInternal(Node nodeA, Node nodeB) {
        if (nodeA == null && nodeB == null) {
            return true;
        }
        if ((nodeA != null && nodeB == null) || nodeA == null && nodeB != null) {
            return false;
        }

        if (nodeA.value != nodeB.value) {
            return false;
        }

        return isEqualInternal(nodeA.left, nodeB.left) && isEqualInternal(nodeB.right, nodeB.right);
    }

    private void internalMirror(Node node) {
        if (node == null) return;
        Node tmp = null;
        tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        internalMirror(node.left);
        internalMirror(node.right);
    }

    private boolean isEnd(Node node) {
        return node.left == null && node.right == null;
    }

    public boolean hasPathSum(int sum) {
        return internalHasPathSum(root, root.value, sum);
    }

    public void printLayers() {
        final HashMap<Integer, List<Integer>> layers = new HashMap<>();
        buildLayerList(root, 0, layers);
        for (Map.Entry<Integer, List<Integer>> entry : layers.entrySet()) {
            Out.pln(entry.getKey() + ":" + Arrays.toString(entry.getValue().toArray()));
        }
    }

    private void buildLayerList(Node node, int layerIndex, HashMap<Integer, List<Integer>> layers) {

        if (node == null) return;

        List<Integer> layerList;

        if (!layers.containsKey(layerIndex)) {
            layerList = new ArrayList<>();
            layers.put(layerIndex, layerList);
        } else {
            layerList = layers.get(layerIndex);
        }

        layerList.add(node.value);

        layerIndex++;
        buildLayerList(node.left, layerIndex, layers);
        buildLayerList(node.right, layerIndex, layers);
    }

    private boolean internalHasPathSum(Node node, int counter, int sum) {

        counter = node.value + counter;

        if (sum == counter) {
            return true;
        } else {
            if (node.left != null) {
                if (internalHasPathSum(node.left, counter, sum)) {
                    return true;
                }
            }

            if (node.right != null) {
                if (internalHasPathSum(node.right, counter, sum)) {
                    return true;
                }
            }
        }

        return false;

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

    private int getDepth(BST.Node node, int depth) {

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

        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }
}
