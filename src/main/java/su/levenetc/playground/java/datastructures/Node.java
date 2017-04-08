package su.levenetc.playground.java.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene.levenetc on 08/04/2017.
 */
public class Node {

    int value;
    List<Node> children = new ArrayList<>();

    public Node(int value) {
        this.value = value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public boolean isEmpty() {
        return children.isEmpty();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
