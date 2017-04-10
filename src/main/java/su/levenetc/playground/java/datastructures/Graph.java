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

    public List<Integer> bfs(int source) {
        List<Integer> visited = new ArrayList<>();
        final Node node = allNodes.get(source);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            final Node polled = queue.poll();
            visited.add(polled.value);
            Out.pln("visited", polled.value);
            final List<Node> children = polled.getNextNodes();
            for (Node child : children) {
                queue.add(child);
            }
        }
        return visited;
    }

    public List<Node> getTopologicalOrdered() {
        if (allNodes.isEmpty()) {
            return Collections.emptyList();
        }

        LinkedList<Node> stack = new LinkedList<>();
        Set<Node> set = new HashSet<>();

        for (int key : allNodes.keySet()) {
            final Node node = allNodes.get(key);
            exploreTopologically(node, stack, set);
        }
        return stack;
    }

    private void exploreTopologically(Node node, LinkedList<Node> stack, Set<Node> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        if (node.isEmpty()) {
            stack.add(node);
            return;
        }
        for (Node child : node.getNextNodes()) {
            if (!visited.contains(child)) {
                exploreTopologically(child, stack, visited);
            }
        }

        stack.add(node);
    }

    public Graph addEdge(int nodeValueA, int nodeValueB) {
        Node nodeA;
        Node nodeB;
        nodeA = allNodes.containsKey(nodeValueA) ? allNodes.get(nodeValueA) : new Node(nodeValueA);
        nodeB = allNodes.containsKey(nodeValueB) ? allNodes.get(nodeValueB) : new Node(nodeValueB);

        nodeA.addNext(nodeB);
        nodeB.addPrev(nodeA);

        if (!allNodes.containsKey(nodeValueA)) allNodes.put(nodeValueA, nodeA);
        if (!allNodes.containsKey(nodeValueB)) allNodes.put(nodeValueB, nodeB);

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

    public List<Set<Node>> stronglyConnectedComponents() {
        Set<Node> nodes = nodesToSet();
        Deque<Node> finishStack = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        for (Node node : nodes) {
            stronglyConnectedDfs(node, finishStack, visited);
        }
        visited.clear();
        List<Set<Node>> components = new ArrayList<>();
        while (!finishStack.isEmpty()) {
            final Node node = finishStack.pop();
            if(visited.contains(node)) continue;
            HashSet<Node> component = new HashSet<>();
            buildStronglyConnectedComponents(node, visited, component);
            components.add(component);
        }
        return components;
    }

    private void buildStronglyConnectedComponents(Node node, Set<Node> visited, Set<Node> currentComponent) {

        if (visited.contains(node)) return;

        visited.add(node);
        currentComponent.add(node);

        final List<Node> prevNodes = node.getPrevNodes();
        for (Node child : prevNodes) {
            buildStronglyConnectedComponents(child, visited, currentComponent);
        }
    }

    private void stronglyConnectedDfs(Node node, Deque<Node> finishStack, Set<Node> visited) {
        if (visited.contains(node)) return;

        visited.add(node);

        final List<Node> children = node.getNextNodes();
        for (Node child : children) {
            if (!visited.contains(child)) {
                stronglyConnectedDfs(child, finishStack, visited);
            }
        }
        finishStack.push(node);
    }

    public boolean hasCycle() {
        Set<Node> white = new HashSet<>();
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
        final List<Node> children = current.getNextNodes();
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

            for (Node child : node.nextNodes) {
                if (visited.contains(child)) continue;
                stack.add(child);
            }
        }
    }

    private TraverseHandler traverse(Node node, TraverseHandler handler) {
        if (node == null || visited.contains(node)) return handler;
        handler.visit(node);
        visited.add(node);
        for (Node child : node.nextNodes) {
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
        for (Node child : node.nextNodes) {
            result = internalFind(child, value);
            visited.add(child);
            if (result != null) break;
        }
        return result;
    }

    interface TraverseHandler {
        void visit(Node node);
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

    private Set<Node> nodesToSet() {
        Set<Node> nodes = new HashSet<>();
        for (int key : allNodes.keySet()) {
            final Node node = allNodes.get(key);
            nodes.add(node);
        }
        return nodes;
    }
}
