package su.levenetc.playground.java.datastructures.multibranch;

import su.levenetc.playground.java.datastructures.multibranch.parts.BasicNode;
import su.levenetc.playground.java.datastructures.multibranch.parts.ForkNode;
import su.levenetc.playground.java.datastructures.multibranch.parts.QueueNode;
import su.levenetc.playground.java.utils.Out;

import static java.lang.String.format;

/**
 * Created by eugene.levenetc on 08/06/2017.
 */
public class BaseFlowNode<Input> implements FlowNode {

    MultiFlowGraph flowBuilder;
    protected String name;

    public BaseFlowNode(MultiFlowGraph flowBuilder) {
        this.flowBuilder = flowBuilder;
    }

    public void goTo(Class<? extends BaseFlowNode<Void>> target) {

    }

    public <Param> void goTo(Class<? extends BaseFlowNode<Param>> target, Param nextParam) {
        flowBuilder.goTo(this, target);
    }

    protected void nextStep() {
        Out.pln(this, "nextStep");
        flowBuilder.goToNext(this);
    }

    public FlowNode then(FlowNode next) {
        QueueNode queueNode = new QueueNode();
        queueNode.then(new BasicNode(this));

        if (next instanceof BaseFlowNode) {
            next = new BasicNode((BaseFlowNode) next);
        }

        queueNode.then(next);
        return queueNode;
    }

    @Override
    public FlowNode next() {
        throw new IllegalStateException("next() should be call on " + getClass().getSimpleName());
    }

    @Override
    public FlowNode prev() {
        throw new IllegalStateException("prev() should be call on " + getClass().getSimpleName());
    }

    @Override
    public void setPrev(FlowNode prev) {
        throw new IllegalStateException("setPrev() should be call on " + getClass().getSimpleName());
    }

    @Override
    public void setNext(FlowNode next) {
        throw new IllegalStateException("setNext() should be call on " + getClass().getSimpleName());
    }

    @Override
    public FlowNode thenOneOf(FlowNode... nextSteps) {
        return new ForkNode().addBranch(new BasicNode(this), nextSteps);
    }

    @Override
    public String toString() {
        return format("{%s}", name);
    }
}

