package su.levenetc.playground.java.datastructures.multibranch.samples;

import su.levenetc.playground.java.datastructures.multibranch.BaseFlowNode;
import su.levenetc.playground.java.datastructures.multibranch.MultiFlowGraph;

/**
 * Created by eugene.levenetc on 09/06/2017.
 */
public class StepFinal extends BaseFlowNode<Void> {
    public StepFinal(MultiFlowGraph flowBuilder) {
        super(flowBuilder);
        name = "Final";
    }
}
