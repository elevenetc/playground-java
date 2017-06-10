package su.levenetc.playground.java.datastructures.multibranch.parts;

import java.util.HashSet;
import java.util.Set;

import su.levenetc.playground.java.datastructures.multibranch.FlowNode;

/**
 * Created by eugene.levenetc on 09/06/2017.
 */
public class ForkNode implements FlowNode {

    public FlowNode prev;
    public FlowNode next;
    public Set<FlowNode> branches = new HashSet<>();

    public ForkNode addBranch(FlowNode from, FlowNode... next) {
        prev = from;
        from.setNext(this);
        for (FlowNode nextNode : next) {
            branches.add(nextNode);
        }
        return this;
    }

    @Override
    public FlowNode then(FlowNode next) {
        return null;
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
        return addBranch(this, nextSteps);
    }
}
