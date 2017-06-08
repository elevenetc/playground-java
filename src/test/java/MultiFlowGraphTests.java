import org.junit.Test;

import su.levenetc.playground.java.datastructures.multibranch.FlowStep;
import su.levenetc.playground.java.datastructures.multibranch.MultiFlowGraph;

/**
 * Created by eugene.levenetc on 07/06/2017.
 */
public class MultiFlowGraphTests {
    @Test
    public void test01() {

        MultiFlowGraph graph = new MultiFlowGraph();

        final StepA stepA = new StepA(graph);
        final StepB stepB = new StepB(graph);
        final StepC stepC = new StepC(graph);
        final StepD stepD = new StepD(graph);
        final StepZ stepZ = new StepZ(graph);
        final StepX stepX = new StepX(graph);
        final StepFinal stepFinal = new StepFinal(graph);

        graph.startWith(stepA)
                .thenOneOf(
                        stepB.then(stepD),
                        stepD.then(stepX)
                        //stepC.then(stepD).then(stepX)
                ).then(stepFinal);
    }

    static class StepA extends FlowStep<Void> {

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

    static class StepB extends FlowStep<String> {

        public StepB(MultiFlowGraph flowBuilder) {
            super(flowBuilder);
            name = "B";
        }

        public void doWork() {
            nextStep();
        }
    }

    static class StepC extends FlowStep<Integer> {

        public StepC(MultiFlowGraph flowBuilder) {
            super(flowBuilder);
            name = "C";
        }
    }

    static class StepD extends FlowStep<Void> {

        public StepD(MultiFlowGraph flowBuilder) {
            super(flowBuilder);
            name = "D";
        }

        public void doWork() {
            nextStep();
        }
    }

    static class StepZ extends FlowStep<Void> {
        public StepZ(MultiFlowGraph flowBuilder) {
            super(flowBuilder);
            name = "Z";
        }
    }

    static class StepX extends FlowStep<Void> {
        public StepX(MultiFlowGraph flowBuilder) {
            super(flowBuilder);
            name = "X";
        }
    }

    static class StepFinal extends FlowStep<Void> {
        public StepFinal(MultiFlowGraph flowBuilder) {
            super(flowBuilder);
            name = "Final";
        }
    }
}
