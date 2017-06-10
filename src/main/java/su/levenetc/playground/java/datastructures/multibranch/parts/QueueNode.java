package su.levenetc.playground.java.datastructures.multibranch.parts;

import java.util.LinkedList;
import java.util.List;

import su.levenetc.playground.java.datastructures.multibranch.FlowNode;

/**
 * Created by eugene.levenetc on 09/06/2017.
 */
public class QueueNode implements FlowNode {

    public List<FlowNode> queue = new LinkedList<>();

    private FlowNode next;
    private FlowNode prev;

    @Override
    public FlowNode then(FlowNode next) {

        if (!queue.isEmpty()) {
            final FlowNode prev = queue.get(queue.size() - 1);
            next.setPrev(prev);
            prev.setNext(next);
        }

        queue.add(next);
        return this;
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
