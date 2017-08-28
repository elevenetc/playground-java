package su.levenetc.playground.java.datastructures.layeredtree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Node {
    String value;
    List<Node> next = new LinkedList<>();

    public static Node fromA(String value) {
        return new NodeA(value);
    }

    public static Node fromB(String value) {
        return new NodeB(value);
    }

    public static Node nodeA(String value) {
        return new NodeA(value);
    }

    public static Node nodeB(String value) {
        return new NodeB(value);
    }

    public Node then(Node... nodes) {
        Collections.addAll(next, nodes);
        return this;
    }

    public Node end() {
        return this;
    }

    @Override
    public String toString() {
        return String.format("{%s}", value);
    }
}
