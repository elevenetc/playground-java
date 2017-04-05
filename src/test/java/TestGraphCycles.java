import org.junit.Test;
import su.levenetc.playground.java.datastructures.Graph;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by eugene.levenetc on 28/03/2017.
 */
public class TestGraphCycles {

    @Test
    public void test01() {
        final Graph graph = new Graph()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(0, 2);
        assertFalse(graph.hasCycle());
    }

    @Test
    public void test02() {
        final Graph graph = new Graph()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0);
        assertTrue(graph.hasCycle());
    }

    @Test
    public void test03() {
        final Graph graph = new Graph()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(0, 2)
                .addEdge(2, 3)
                .addEdge(0, 3)
                .addEdge(0, 3)
                .addEdge(1, 4)
                .addEdge(2, 4);
        assertFalse(graph.hasCycle());
    }

    @Test
    public void test04() {
        final Graph graph = new Graph()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0);
        assertTrue(graph.hasCycle());
    }

    @Test
    public void test05() {
        final Graph graph = new Graph()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(1, 4)
                .addEdge(4, 2);
        assertFalse(graph.hasCycle());
    }

    @Test
    public void test06() {
        final Graph graph = new Graph()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(1, 4)
                .addEdge(4, 2);
        assertFalse(graph.hasCycle());
    }

    @Test
    public void test07() {
        final Graph graph = new Graph()
                .addEdge(0, 1)
                .addEdge(1, 0);
        assertTrue(graph.hasCycle());
    }

    @Test
    public void test08() {
        final Graph graph = new Graph()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(4, 5);
        assertFalse(graph.hasCycle());
    }

    @Test
    public void test09() {
        final Graph graph = new Graph()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(4, 5)
                .addEdge(5, 4);
        assertTrue(graph.hasCycle());
    }

    @Test
    public void test10() {
        final Graph graph = new Graph()
                .addEdge(1, 0)
                .addEdge(2, 0)
                .addEdge(3, 0)
                .addEdge(4, 0)
                .addEdge(5, 0);
        assertFalse(graph.hasCycle());
    }

    @Test
    public void test11() {
        final Graph graph = new Graph()
                .addEdge(0, 1)
                .addEdge(1, 0);
        assertTrue(graph.hasCycle());
    }
}
