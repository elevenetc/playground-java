package su.levenetc.playground.java.datastructures.multibranch;

import java.util.List;

/**
 * Created by eugene.levenetc on 08/06/2017.
 */
public class Node {
    public Node next;
    public List<Node> nextNodes;
    private FlowStep flowStep;

    public Node(FlowStep flowStep) {

        this.flowStep = flowStep;
    }
}
