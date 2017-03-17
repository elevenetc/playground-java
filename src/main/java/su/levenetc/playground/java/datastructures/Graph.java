package su.levenetc.playground.java.datastructures;

import su.levenetc.playground.java.utils.Out;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eugene.levenetc on 17/03/2017.
 */
public class Graph {

    Node root;
    Set<Node> visited = new HashSet<>();

    public void set(Node root) {
        this.root = root;
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

    public int size(){
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

        public void addChild(Node child) {
            children.add(child);
        }

        public boolean isEmpty() {
            return children.isEmpty();
        }
    }

    private static class SizeTraverseHandler implements TraverseHandler{

        int size;

        @Override
        public void visit(Node node) {
            size++;
        }
    }
}
