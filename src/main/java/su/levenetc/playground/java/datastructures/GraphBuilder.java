package su.levenetc.playground.java.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene.levenetc on 27/03/2017.
 */
public class GraphBuilder {

    private List<int[]> edges = new ArrayList<>();
    private boolean bidirectional;
    private int nodes;

    public GraphBuilder() {

    }

    public GraphBuilder setNodes(int nodes) {
        this.nodes = nodes;
        return this;
    }

    public GraphBuilder setBidirectional() {
        bidirectional = true;
        return this;
    }

    public GraphBuilder addEdge(int nodeA, int nodeB) {
        edges.add(new int[]{nodeA, nodeB});
        return this;
    }

    public int[][] toMatrix() {
        final int[][] edges = toEdgesArray();
        final int[][] result = new int[nodes][nodes];

        for (int e = 0; e < edges.length; e++) {
            final int[] edge = edges[e];
            result[edge[0]][edge[1]] = 1;
            if (bidirectional) {
                result[edge[1]][edge[0]] = 1;
            }
        }

        return result;
    }

    public int[][] toEdgesArray() {
        int[][] result = new int[edges.size()][2];
        for (int i = 0; i < edges.size(); i++) {
            int[] edge = edges.get(i);
            result[i] = edge;
        }
        return result;
    }
}