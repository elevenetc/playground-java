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
        AdjListGraph graph = new AdjListGraph(11);
        graph.addEdge(0, 1);
        graph.addEdge(0, 10);
        graph.addEdge(1, 4);
        assertTrue(graph.connected(0, 1));
        assertTrue(graph.connected(0, 10));
        assertTrue(graph.connected(1, 4));
        assertFalse(graph.connected(1, 3));
    }
}