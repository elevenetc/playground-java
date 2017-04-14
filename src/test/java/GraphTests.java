import org.junit.Test;
import su.levenetc.playground.java.datastructures.Graph;
import su.levenetc.playground.java.datastructures.Node;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.Utils;

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
        Node nodeA = new Node(0);
        Node nodeB = new Node(1);
        Node nodeC = new Node(2);
        Node nodeD = new Node(3);
        nodeA.addNext(nodeB);
        nodeB.addNext(nodeC);
        nodeC.addNext(nodeD);
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

    @Test
    public void bfs() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        assertEquals(Utils.toList(0, 1, 2, 3, 4, 5), graph.bfs(0));
    }

    static Graph createCycleGraph() {
        Graph graph = new Graph();
        Node nodeA = new Node(0);
        Node nodeB = new Node(1);
        Node nodeC = new Node(2);
        Node nodeD = new Node(3);
        Node nodeE = new Node(4);
        nodeA.addNext(nodeB);
        nodeB.addNext(nodeC);
        nodeC.addNext(nodeD);
        nodeD.addNext(nodeE);
        nodeE.addNext(nodeA);
        nodeC.addNext(nodeE);
        nodeE.addNext(nodeC);
        graph.set(nodeA);
        return graph;
    }

    static Graph createNonCycleGraph() {
        Graph graph = new Graph();
        Node nodeA = new Node(0);
        Node nodeB = new Node(1);
        Node nodeC = new Node(2);
        Node nodeD = new Node(3);
        nodeA.addNext(nodeB);
        nodeB.addNext(nodeC);
        nodeC.addNext(nodeD);
        graph.set(nodeA);
        return graph;
    }

}
