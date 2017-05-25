import org.junit.Test;
import su.levenetc.playground.java.datastructures.AdjListGraph;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by eugene.levenetc on 25/05/2017.
 */
public class TestAdjListGraph {
    @Test
    public void test01() {
        AdjListGraph graph = AdjListGraph.nonDirected(11);
        graph.addEdge(0, 1);
        graph.addEdge(0, 10);
        graph.addEdge(1, 4);
        assertTrue(graph.connected(0, 1));
        assertTrue(graph.connected(1, 0));
        assertTrue(graph.connected(0, 10));
        assertTrue(graph.connected(1, 4));
        assertFalse(graph.connected(1, 3));
    }

    @Test
    public void test02() {
        AdjListGraph graph = AdjListGraph.directed(11);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        assertTrue(graph.connected(0, 1));
        assertTrue(graph.connected(1, 2));
        assertFalse(graph.connected(2, 1));
        assertFalse(graph.connected(1, 0));
        assertFalse(graph.connected(10, 100));
    }

    @Test
    public void test03() {
        AdjListGraph graph = AdjListGraph.directed(11);
        graph.addEdge(0, 1);
        assertTrue(graph.contains(0));
        assertTrue(graph.contains(1));
        assertFalse(graph.contains(100));
    }
}