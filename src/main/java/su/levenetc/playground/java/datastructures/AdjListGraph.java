package su.levenetc.playground.java.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene.levenetc on 25/05/2017.
 */
public class AdjListGraph {

    List<Integer>[] nodes;

    public AdjListGraph(int n) {
        nodes = (ArrayList<Integer>[]) new ArrayList[n];
    }

    public void addEdge(int nodeA, int nodeB) {
        List<Integer> listA;
        List<Integer> listB;
        if (nodes[nodeA] == null) {
            listA = new ArrayList<>();
            nodes[nodeA] = listA;
        } else {
            listA = nodes[nodeA];
        }

        if (nodes[nodeB] == null) {
            listB = new ArrayList<>();
            nodes[nodeB] = listB;
        } else {
            listB = nodes[nodeB];
        }

        listA.add(nodeB);
        listB.add(nodeA);
    }

    public boolean connected(int nodeA, int nodeB) {
        if (nodes[nodeA] == null || nodes[nodeB] == null) return false;
        return nodes[nodeA].contains(nodeB) && nodes[nodeB].contains(nodeA);
    }
}