import org.junit.Before;
import org.junit.Test;

import su.levenetc.playground.java.datastructures.multibranch.MultiFlowGraph;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepA;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepB;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepC;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepD;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepFinal;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepX;
import su.levenetc.playground.java.datastructures.multibranch.samples.StepZ;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 07/06/2017.
 */
public class MultiFlowGraphTests {

    private MultiFlowGraph graph;
    private StepA stepA;
    private StepB stepB;
    private StepC stepC;
    private StepD stepD;
    private StepZ stepZ;
    private StepX stepX;
    private StepFinal stepFinal;

    @Before
    public void before() {
        graph = new MultiFlowGraph();

        stepA = new StepA(graph);
        stepB = new StepB(graph);
        stepC = new StepC(graph);
        stepD = new StepD(graph);
        stepZ = new StepZ(graph);
        stepX = new StepX(graph);
        stepFinal = new StepFinal(graph);
    }

    @Test
    public void test01() {

//        graph.startWith(stepA)
//                .then(stepB)
//                .then(stepC)
//                .thenOneOf(
//                        stepZ,
//                        stepX
//                );
//
//        graph.start();
//        graph.next();
//        graph.next();
//        assertEquals(stepC, graph.getCurrent());
    }

}