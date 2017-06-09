package su.levenetc.playground.java.datastructures.multibranch.samples;

import su.levenetc.playground.java.datastructures.multibranch.BaseFlowNode;
import su.levenetc.playground.java.datastructures.multibranch.MultiFlowGraph;

/**
 * Created by eugene.levenetc on 09/06/2017.
 */
public class StepB extends BaseFlowNode<String> {

    public StepB(MultiFlowGraph flowBuilder) {
        super(flowBuilder);
        name = "B";
    }

    public void doWork() {
        nextStep();
    }
}
