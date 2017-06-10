import org.junit.Test;

import su.levenetc.playground.java.datastructures.multibranch.FlowNode;
import su.levenetc.playground.java.datastructures.multibranch.MultiFlowGraph;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepA;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepB;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepC;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepD;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepFinal;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepX;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepZ;

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

        final FlowNode result = stepA
                .then(stepB)
                .then(stepC)
                .thenOneOf(
                        stepZ,
                        stepX
                );

        if (result == null) {

        }

        final FlowNode last = graph.startWith(stepA)
                .thenOneOf(
                        stepB.then(stepC).then(stepD),
                        stepD.then(stepX)
                        //stepC.then(stepD).then(stepX)
                ).then(stepFinal);
    }

}
