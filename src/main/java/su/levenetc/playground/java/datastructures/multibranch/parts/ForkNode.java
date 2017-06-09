package su.levenetc.playground.java.datastructures.multibranch.parts;

import java.util.LinkedList;
import java.util.List;

import su.levenetc.playground.java.datastructures.multibranch.FlowNode;

/**
 * Created by eugene.levenetc on 09/06/2017.
 */
public class ForkNode implements FlowNode {

    public FlowNode from;
    public List<List<FlowNode>> paths = new LinkedList<>();

    public FlowNode next;

    @Override
    public FlowNode then(FlowNode next) {
        this.next = next;
        return this;
    }

    @Override
    public FlowNode next() {
        return null;
    }

    @Override
    public FlowNode prev() {
        return null;
    }

    @Override
    public void setPrev(FlowNode prev) {

    }

    @Override
    public void setNext(FlowNode next) {

    }
}
