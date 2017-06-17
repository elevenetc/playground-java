package su.levenetc.playground.java.datastructures.multibranch.parts;

import su.levenetc.playground.java.datastructures.multibranch.BaseFlowNode;
import su.levenetc.playground.java.datastructures.multibranch.FlowNode;

/**
 * Created by eugene.levenetc on 15/06/2017.
 */
public class BasicNode implements FlowNode {

    private BaseFlowNode node;
    private FlowNode prev;
    private FlowNode next;

    public BasicNode(BaseFlowNode node) {

        this.node = node;
    }

    @Override
    public FlowNode then(FlowNode next) {
        QueueNode queueNode = new QueueNode();
        queueNode.then(this);
        queueNode.then(next);
        return queueNode;
    }

    @Override
    public FlowNode next() {
        return next;
    }

    @Override
    public FlowNode prev() {
        return prev;
    }

    @Override
    public void setPrev(FlowNode prev) {

        this.prev = prev;
    }

    @Override
    public void setNext(FlowNode next) {

        this.next = next;
    }

    @Override
    public FlowNode thenOneOf(FlowNode... nextSteps) {
        return new ForkNode().addBranch(this, nextSteps);
    }

}