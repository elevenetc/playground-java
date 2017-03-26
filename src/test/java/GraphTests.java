import org.junit.Test;
import su.levenetc.playground.java.datastructures.Graph;
import su.levenetc.playground.java.utils.Out;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 17/03/2017.
 */
public class GraphTests {

    @Test
    public void testSize() {
        assertEquals(5, createCycleGraph().size());
        assertEquals(4, createNonCycleGraph().size());
    }

    @Test
    public void testFind() {
        Graph graph = new Graph();
        Graph.Node nodeA = new Graph.Node(0);
        Graph.Node nodeB = new Graph.Node(1);
        Graph.Node nodeC = new Graph.Node(2);
        Graph.Node nodeD = new Graph.Node(3);
        nodeA.addChild(nodeB);
        nodeB.addChild(nodeC);
        nodeC.addChild(nodeD);
        graph.set(nodeA);
        assertEquals(nodeC, graph.find(2));
        assertEquals(null, graph.find(10));
    }

    @Test
    public void traverse() {
        createNonCycleGraph().print();
        Out.pln();
        createCycleGraph().print();
    }

    @Test
    public void testFindCircular() {
        Graph graph = createCycleGraph();
        assertEquals(true, graph.contains(2));
        assertEquals(null, graph.find(10));
    }

    @Test
    public void replace() {
        final Graph graph = createNonCycleGraph();
        assertEquals(true, graph.replace(2, 10));
        assertEquals(true, graph.contains(10));
        assertEquals(false, graph.contains(2));
    }

    @Test
    public void traverseIterate() {
        Graph graph = createCycleGraph();
        graph.traverseIterative();
    }

    static Graph createCycleGraph() {
        Graph graph = new Graph();
        Graph.Node nodeA = new Graph.Node(0);
        Graph.Node nodeB = new Graph.Node(1);
        Graph.Node nodeC = new Graph.Node(2);
        Graph.Node nodeD = new Graph.Node(3);
        Graph.Node nodeE = new Graph.Node(4);
        nodeA.addChild(nodeB);
        nodeB.addChild(nodeC);
        nodeC.addChild(nodeD);
        nodeD.addChild(nodeE);
        nodeE.addChild(nodeA);
        nodeC.addChild(nodeE);
        nodeE.addChild(nodeC);
        graph.set(nodeA);
        return graph;
    }

    static Graph createNonCycleGraph() {
        Graph graph = new Graph();
        Graph.Node nodeA = new Graph.Node(0);
        Graph.Node nodeB = new Graph.Node(1);
        Graph.Node nodeC = new Graph.Node(2);
        Graph.Node nodeD = new Graph.Node(3);
        nodeA.addChild(nodeB);
        nodeB.addChild(nodeC);
        nodeC.addChild(nodeD);
        graph.set(nodeA);
        return graph;
    }

}
