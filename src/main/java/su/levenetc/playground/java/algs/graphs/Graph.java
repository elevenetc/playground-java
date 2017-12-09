package su.levenetc.playground.java.algs.graphs;

import java.util.*;

public class Graph {

    public final Set<GNode> nodesSet = new HashSet<>();
    public final List<GNode> nodesList = new LinkedList<>();

    public Graph() {

    }

    public Graph(GNode... nodes) {
        add(nodes);
    }

    public GNode node(int index) {
        return nodesList.get(index);
    }

    public void add(GNode... nodes) {
        this.nodesSet.addAll(Arrays.asList(nodes));
        this.nodesList.addAll(Arrays.asList(nodes));
    }

    @Override
    public String toString() {
        return nodesList.toString();
    }
}
