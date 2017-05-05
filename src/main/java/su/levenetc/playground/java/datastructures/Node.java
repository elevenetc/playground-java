package su.levenetc.playground.java.datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eugene.levenetc on 08/04/2017.
 */
public class Node {

    int value;
    List<Node> nextNodes = new ArrayList<>();
    List<Node> prevNodes = new ArrayList<>();

    public Node(int value) {
        this.value = value;
    }

    public boolean isNeighbour(Node node) {
        return nextNodes.contains(node);
    }

    public List<Node> getNextNodes() {
        return nextNodes;
    }

    public List<Node> getPrevNodes() {
        return prevNodes;
    }

    public void addPrev(Node child) {
        prevNodes.add(child);
    }

    public void addNext(Node child) {
        nextNodes.add(child);
    }

    public boolean isEmpty() {
        return nextNodes.isEmpty();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return value == node.value;
    }

    public static List<Node> nodesList(int... nodes) {
        List<Node> result = new ArrayList<>();
        for (int i : nodes)
            result.add(new Node(i));
        return result;
    }

    public static Set<Node> nodesSet(int... nodes) {
        Set<Node> result = new HashSet<>();
        for (int i : nodes)
            result.add(new Node(i));
        return result;
    }

    public static Node[] nodes(int... nodes) {
        Node[] result = new Node[nodes.length];
        for (int i = 0; i < nodes.length; i++)
            result[i] = new Node(nodes[i]);
        return result;
    }
}
