package su.levenetc.playground.java.datastructures;

import java.util.*;

/**
 * Created by eugene.levenetc on 25/05/2017.
 */
public class AdjListGraph {

    List<Integer>[] nodes;
    private boolean directed;

    public static AdjListGraph directed(int n) {
        return new AdjListGraph(n, true);
    }

    public static AdjListGraph nonDirected(int n) {
        return new AdjListGraph(n, false);
    }

    private AdjListGraph(int n, boolean directed) {
        nodes = (ArrayList<Integer>[]) new ArrayList[n];
        this.directed = directed;
    }

    public void reverse() {
        List<Integer>[] newNodes = (ArrayList<Integer>[]) new ArrayList[nodes.length];

        for (int node = 0; node < nodes.length; node++) {

            if (newNodes[node] == null) {
                newNodes[node] = new ArrayList<>();
            }

            List<Integer> children = nodes[node];
            for (int child : children) {
                if (newNodes[child] == null) {
                    newNodes[child] = new ArrayList<>();
                }
                newNodes[child].add(node);
            }
        }
        nodes = newNodes;
    }

    public Set<Set<Integer>> connectedComponents() {
        boolean[] visited = new boolean[nodes.length];
        Deque<Integer> finishStack = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            calcDFSByFinish(i, visited, finishStack);
        }
        reverse();
        Arrays.fill(visited, false);
        Set<Set<Integer>> components = new HashSet<>();
        while (!finishStack.isEmpty()) {
            int pop = finishStack.pop();
            Set<Integer> component = connectedDFS(pop, visited);
            if (component != null) {
                components.add(component);
            }
        }
        return components;
    }

    private void calcDFSByFinish(int from, boolean[] visited, Deque<Integer> finishStack) {

        if (visited[from]) return;
        visited[from] = true;

        List<Integer> children = nodes[from];

        for (int child : children) calcDFSByFinish(child, visited, finishStack);

        finishStack.push(from);
    }

    private Set<Integer> connectedDFS(int node, boolean[] visited) {
        if (visited[node]) return null;

        Deque<Integer> stack = new LinkedList<>();
        Set<Integer> component = new HashSet<>();
        visited[node] = true;
        stack.push(node);

        while (!stack.isEmpty()) {
            int popped = stack.pop();
            component.add(popped);
            List<Integer> children = nodes[popped];
            for (int child : children) {
                if (visited[child]) continue;
                visited[child] = true;
                stack.push(child);
            }
        }

        return component;
    }

    public void addEdge(int nodeFrom, int nodeTo) {
        List<Integer> listA;
        List<Integer> listB;
        if (nodes[nodeFrom] == null) {
            listA = new ArrayList<>();
            nodes[nodeFrom] = listA;
        } else {
            listA = nodes[nodeFrom];
        }

        if (nodes[nodeTo] == null) {
            listB = new ArrayList<>();
            nodes[nodeTo] = listB;
        } else {
            listB = nodes[nodeTo];
        }

        if (directed) {
            listA.add(nodeTo);
        } else {
            listA.add(nodeTo);
            listB.add(nodeFrom);
        }
    }

    public boolean contains(int node) {
        return node <= nodes.length - 1 && nodes[node] != null;
    }

    public boolean connected(int nodeFrom, int nodeTo) {
        if (nodes[nodeFrom] == null || nodes[nodeTo] == null) return false;

        if (directed) {
            return nodes[nodeFrom].contains(nodeTo);
        } else {
            return nodes[nodeFrom].contains(nodeTo) && nodes[nodeTo].contains(nodeFrom);
        }
    }
}