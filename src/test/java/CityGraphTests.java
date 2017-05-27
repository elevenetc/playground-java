import org.junit.Test;
import su.levenetc.playground.java.datastructures.CityGraph;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 27/05/2017.
 */
public class CityGraphTests {
    @Test
    public void test01() {
        CityGraph graph = new CityGraph(4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        graph.cmd(1, 2, 0);
        assertEquals("No", graph.cmd(2, 3, 5));
        assertEquals("Yes", graph.cmd(2, 1, 5));
        graph.cmd(1, 1, 1);
        assertEquals("Yes", graph.cmd(2, 6, 4));
    }

    @Test
    public void test02() {
        CityGraph graph = new CityGraph(4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        assertEquals("No", graph.isConnectedCmd(1, 100));
        assertEquals("Yes", graph.isConnectedCmd(1, 2));
        assertEquals("Yes", graph.isConnectedCmd(1, 4));
    }

    @Test
    public void test03() {
        CityGraph graph = new CityGraph(4);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.createNewCityFrom(1);
        graph.createNewCityTo(2);

        assertEquals("No", graph.isConnectedCmd(1, 100));
        assertEquals("Yes", graph.isConnectedCmd(1, 2));
        assertEquals("Yes", graph.isConnectedCmd(1, 4));
        assertEquals("Yes", graph.isConnectedCmd(1, 5));
        assertEquals("No", graph.isConnectedCmd(5, 1));
        assertEquals("Yes", graph.isConnectedCmd(6, 2));
        assertEquals("No", graph.isConnectedCmd(2, 6));
    }
}
