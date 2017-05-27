package su.levenetc.playground.java.datastructures;

import java.util.*;

/**
 * Created by eugene.levenetc on 27/05/2017.
 */
public class CityGraph {

    Map<Integer, Node> nodes = new HashMap<>();
    private int cities;

    public CityGraph(int cities) {

        this.cities = cities;
    }

    public String isConnectedCmd(int from, int to) {
        return cmd(2, from, to);
    }

    public void createNewCityTo(int target) {
        cmd(1, target, 1);
    }

    public void createNewCityFrom(int target) {
        cmd(1, target, 0);
    }

    public String cmd(int cmd, int a, int b) {
        if (cmd == 1) {
            int to = a;
            int dir = b;

            if (dir == 0) {
                addEdge(to, ++cities);
            } else if (dir == 1) {
                addEdge(++cities, to);
            }

        } else if (cmd == 2) {
            int from = a;
            int to = b;
            return isConnected(from, to) ? "Yes" : "No";
        }
        return null;
    }

    public void addEdge(int from, int to) {

        Node nodeFrom = nodes.get(from);
        Node nodeTo = nodes.get(to);

        if (nodeFrom == null) {
            nodeFrom = new Node(from);
            nodes.put(from, nodeFrom);
        }

        if (nodeTo == null) {
            nodeTo = new Node(to);
            nodes.put(to, nodeTo);
        }

        nodeFrom.addChild(nodeTo);
    }

    boolean isConnected(int from, int to) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Node start = nodes.get(from);
        Node finish = nodes.get(to);

        if (start == null || finish == null) return false;

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Node polled = queue.poll();

            for (Node child : polled.children) {
                if (visited.contains(child)) continue;

                if (child.value == finish.value) {
                    return true;
                }

                visited.add(child);
                queue.add(child);
            }
        }

        return false;
    }

    static class Node {

        int value;
        List<Node> children = new LinkedList<>();

        Node(int value) {
            this.value = value;
        }

        void addChild(Node child) {
            children.add(child);
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return ((Node) obj).value == value;
        }
    }
}
