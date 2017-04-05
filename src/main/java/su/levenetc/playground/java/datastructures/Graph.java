package su.levenetc.playground.java.datastructures;

import su.levenetc.playground.java.utils.Out;

import java.util.*;

/**
 * Created by eugene.levenetc on 17/03/2017.
 */
public class Graph {

    Node root;
    Set<Node> visited = new HashSet<>();
    Map<Integer, Node> allNodes = new HashMap<>();

    public void set(Node root) {
        this.root = root;
    }

    public Graph addEdge(int valueA, int valueB) {
        Node nodeA;
        Node nodeB;
        nodeA = allNodes.containsKey(valueA) ? allNodes.get(valueA) : new Node(valueA);
        nodeB = allNodes.containsKey(valueB) ? allNodes.get(valueB) : new Node(valueB);
        nodeA.addChild(nodeB);

        if (!allNodes.containsKey(valueA)) allNodes.put(valueA, nodeA);
        if (!allNodes.containsKey(valueB)) allNodes.put(valueB, nodeB);
        return this;
    }

    public Node find(int value) {
        return internalFind(root, value);
    }

    public boolean contains(int value) {
        visited.clear();
        return internalFind(root, value) != null;
    }

    public boolean replace(int find, int value) {
        visited.clear();
        Node node = internalFind(root, find);
        if (node == null) {
            return false;
        } else {
            node.value = value;
            return true;
        }
    }

    public int size() {
        final SizeTraverseHandler handler = new SizeTraverseHandler();
        traverse(root, handler);
        return handler.size;
    }

    public void print() {
        if (root == null) return;
        visited.clear();
        traverse(root, node -> {
            Out.p(" > ");
            Out.p("{" + node.value + "}");
        });
    }

    public boolean hasCycle() {
        HashSet<Node> white = new HashSet<>();
        Set<Node> grey = new HashSet<>();
        Set<Node> black = new HashSet<>();
        for (int key : allNodes.keySet()) {
            final Node node = allNodes.get(key);
            white.add(node);
        }

        while (!white.isEmpty()) {
            if (dfsHasCycle(white.iterator().next(), white, grey, black)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfsHasCycle(Node current, Set<Node> white, Set<Node> grey, Set<Node> black) {
        if (current == null) return false;
        move(current, white, grey);
        final List<Node> children = current.getChildren();
        for (Node child : children) {
            if (black.contains(child)) {
                continue;
            }
            if (grey.contains(child)) {
                return true;
            }
            if (dfsHasCycle(child, white, grey, black)) {
                return true;
            }
        }
        move(current, grey, black);
        return false;
    }

    private void move(Node node, Set<Node> from, Set<Node> to) {
        from.remove(node);
        to.add(node);
    }

    public void traverseIterative() {
        PrintTraverseHandler handler = new PrintTraverseHandler();
        LinkedList<Node> stack = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            final Node node = stack.pop();

            if (visited.contains(node)) continue;

            handler.visit(node);
            visited.add(node);

            for (Node child : node.children) {
                if (visited.contains(child)) continue;
                stack.add(child);
            }
        }
    }

    private TraverseHandler traverse(Node node, TraverseHandler handler) {
        if (node == null || visited.contains(node)) return handler;
        handler.visit(node);
        visited.add(node);
        for (Node child : node.children) {
            traverse(child, handler);
        }
        return handler;
    }

    private Node internalFind(Node node, int value) {
        if (node == null) return null;
        if (visited.contains(node)) return null;
        if (node.value == value) return node;
        if (node.isEmpty()) return null;
        Node result = null;
        for (Node child : node.children) {
            result = internalFind(child, value);
            visited.add(child);
            if (result != null) break;
        }
        return result;
    }

    interface TraverseHandler {
        void visit(Node node);
    }

    public static class Node {

        int value;
        List<Node> children = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void addChild(Node child) {
            children.add(child);
        }

        public boolean isEmpty() {
            return children.isEmpty();
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private static class PrintTraverseHandler implements TraverseHandler {

        @Override
        public void visit(Node node) {
            Out.pln("visit: " + node.value);
        }
    }

    private static class SizeTraverseHandler implements TraverseHandler {

        int size;

        @Override
        public void visit(Node node) {
            size++;
        }
    }
}
