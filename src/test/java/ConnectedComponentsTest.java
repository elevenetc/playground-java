import org.junit.Test;
import su.levenetc.playground.java.datastructures.Graph;
import su.levenetc.playground.java.datastructures.Node;
import utils.AssertUtils;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.datastructures.Node.nodes;

/**
 * Created by eugene.levenetc on 11/04/2017.
 */
public class ConnectedComponentsTest {
    @Test
    public void test01() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        final List<Set<Node>> connected = graph.stronglyConnectedComponents();
        AssertUtils.assertContains(connected, nodes(3));
        AssertUtils.assertContains(connected, nodes(0, 1, 2));
    }

    @Test
    public void test02() {
        Graph graph = new Graph();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        final List<Set<Node>> connected = graph.stronglyConnectedComponents();
        assertEquals(1, connected.size());
        AssertUtils.assertContains(connected, nodes(0, 1, 2));
    }

}