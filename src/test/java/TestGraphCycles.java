import org.junit.Test;
import su.levenetc.playground.java.algs.GraphUtils;
import su.levenetc.playground.java.datastructures.GraphBuilder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by eugene.levenetc on 28/03/2017.
 */
public class TestGraphCycles {
    @Test
    public void test01() {
        final int[][] matrix = new GraphBuilder()
                .setNodes(3)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(0, 2)
                .toMatrix();
        assertFalse(GraphUtils.containsCycle(matrix));
    }

    @Test
    public void test02() {
        final int[][] matrix = new GraphBuilder()
                .setNodes(3)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .toMatrix();
        assertTrue(GraphUtils.containsCycle(matrix));
    }

    @Test
    public void test03() {



        final int[][] matrix = new GraphBuilder()
                .setNodes(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(0, 2)
                .addEdge(2, 3)
                .addEdge(0, 3)
                .addEdge(0, 3)
                .addEdge(1, 4)
                .addEdge(2, 4)
                .toMatrix();
        assertFalse(GraphUtils.containsCycle(matrix));
    }
}
