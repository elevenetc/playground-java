package su.levenetc.playground.java.algs.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class GNode {

    public static GNode node(int value) {
        return new GNode(value);
    }

    public final int value;
    public final List<GNode> children = new LinkedList<>();

    public GNode(int value) {
        this.value = value;
    }

    public void child(GNode node) {
        children.add(node);
    }

    public GNode add(GNode node) {
        children.add(node);
        return node;
    }

    public void add(GNode... nodes) {
        children.addAll(Arrays.asList(nodes));
    }

    public void add(int... nodes) {
        for (int nodeValue : nodes)
            add(node(nodeValue));
    }

    @Override
    public String toString() {
        return String.format("(%d)", value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GNode gNode = (GNode) o;
        return value == gNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
