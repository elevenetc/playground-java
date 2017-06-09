package su.levenetc.playground.java.datastructures.multibranch.samples;

import su.levenetc.playground.java.datastructures.multibranch.BaseFlowNode;
import su.levenetc.playground.java.datastructures.multibranch.MultiFlowGraph;

/**
 * Created by eugene.levenetc on 09/06/2017.
 */
public class StepA extends BaseFlowNode<Void> {

    int value = 10;

    public StepA(MultiFlowGraph flowBuilder) {
        super(flowBuilder);
        name = "A";
    }

    public void doWork() {

        if (value == 10) {
            goTo(StepB.class, "");
        } else {
            goTo(StepC.class, 10);
        }
    }
}
