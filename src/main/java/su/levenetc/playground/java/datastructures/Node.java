package su.levenetc.playground.java.datastructures;

import java.util.ArrayList;
import java.util.List;

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
}
