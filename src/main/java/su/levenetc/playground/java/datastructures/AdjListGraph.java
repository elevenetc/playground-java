package su.levenetc.playground.java.datastructures;

import java.util.ArrayList;
import java.util.List;

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