import org.junit.Test;
import su.levenetc.playground.java.datastructures.Graph;
import su.levenetc.playground.java.datastructures.Node;

import java.util.List;
import java.util.Set;

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
        final List<Set<Node>> components = graph.stronglyConnectedComponents();
        AssertUtils.assertContains(components, nodes(3));
        AssertUtils.assertContains(components, nodes(0, 1, 2));
    }
}