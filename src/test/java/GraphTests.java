import org.junit.Test;
import su.levenetc.playground.java.datastructures.Graph;
import su.levenetc.playground.java.datastructures.Node;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.Utils;

import java.util.Map;
import java.util.Set;

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

    @Test
    public void testLayers() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(0, 7);
        graph.addEdge(7, 8);
        final Map<Integer, Set<Node>> layers = graph.getLayers2(0);

        AssertUtils.assertContains(layers, Node.nodes(0));
        AssertUtils.assertContains(layers, Node.nodes(1, 2, 7));
        AssertUtils.assertContains(layers, Node.nodes(3, 4, 5, 6, 8));
    }

    @Test
    public void testTopology01() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        assertEquals(Node.nodesList(0, 1), graph.getTopologicalOrdered());
    }

    @Test
    public void testTopology02() {
        Graph graph = new Graph();
        graph.addEdge(4, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 1);
        assertEquals(Node.nodesList(4, 3, 1, 2), graph.getTopologicalOrdered());
    }

    @Test
    public void testBFSShortest01() {
        Graph graph = new Graph();
        graph.addBiEdge(1, 4);
        graph.addBiEdge(1, 3);
        graph.addBiEdge(1, 2);
        graph.addBiEdge(3, 2);
        graph.addBiEdge(4, 6);
        graph.addBiEdge(6, 7);
        graph.addBiEdge(2, 10);

//        final List<Node> path = graph.bfsShortestPathLength(2, 7);
//        assertEquals(shortest, path);
    }

    @Test
    public void testBFSShortest02() {
        Graph graph = new Graph();
        graph.addBiEdge(1, 2);
        graph.addBiEdge(3, 4);

//        final List<Node> path = graph.bfsShortestPathLength(1, 4);
//        assertEquals(shortest, path);
    }

    @Test
    public void testBFSShortest03() {
        Graph graph = new Graph();
        graph.addBiEdge(0, 1);
        graph.addBiEdge(0, 2);
        graph.addBiEdge(0, 3);
        graph.addBiEdge(2, 1);
        graph.addBiEdge(3, 1);

//        final List<Node> path = graph.bfsShortestPathLength(0, 1);
//        assertEquals(shortest, path);
    }

    @Test
    public void testBFSShortest04() {
        Graph graph = new Graph();
        graph.addBiEdge(0, 1);
        graph.addBiEdge(1, 2);
        graph.addBiEdge(2, 0);

//        final List<Node> path = graph.bfsShortestPathLength(0, 2);
//        assertEquals(shortest, path);
    }

    @Test
    public void testBFSShortest05() {
        Graph graph = new Graph();
        graph.addBiEdge(0, 1);
        graph.addBiEdge(1, 3);
        graph.addBiEdge(3, 2);
        graph.addBiEdge(2, 0);
        graph.addBiEdge(0, 3);
        graph.addBiEdge(3, 10);

        final int dist = graph.bfsShortestPathLength(0, 10);
        assertEquals(2, dist);
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
