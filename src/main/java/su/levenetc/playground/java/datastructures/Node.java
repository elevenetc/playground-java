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

    public static Set<Node> nodesSet(int... set) {
        Set<Node> result = new HashSet<>();
        for (int i : set)
            result.add(new Node(i));
        return result;
    }

    public static Node[] nodes(int... set) {
        Node[] result = new Node[set.length];
        for (int i = 0; i < set.length; i++)
            result[i] = new Node(set[i]);
        return result;
    }
}
