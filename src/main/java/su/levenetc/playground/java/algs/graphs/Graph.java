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

    public void resetNodes(Set<GNode> nodes) {
        LinkedList<GNode> list = new LinkedList<>(nodes);
        nodesList.clear();
        nodesSet.clear();

        nodesList.addAll(list);
        nodesSet.addAll(list);
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

    public GNode get(int value) {
        for (GNode node : nodesSet) {
            if (node.value == value) {
                return node;
            }
        }
        return null;
    }

    public static Set<GNode> traverseAll(GNode node) {
        Set<GNode> visited = new HashSet<>();
        Queue<GNode> q = new LinkedList<>();

        q.offer(node);
        while (!q.isEmpty()) {
            GNode poll = q.poll();
            if (visited.contains(poll)) continue;

            visited.add(poll);

            for (GNode child : poll.children) {
                q.add(child);
            }
        }
        return visited;
    }
}
