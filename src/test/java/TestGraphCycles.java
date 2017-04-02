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
        //assertFalse(GraphUtils.containsCycleRecursive(matrix));
        assertFalse(GraphUtils.containsCycleIterative(matrix));
    }

    @Test
    public void test02() {
        final int[][] matrix = new GraphBuilder()
                .setNodes(3)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .toMatrix();
        assertTrue(GraphUtils.containsCycleRecursive(matrix));
        assertTrue(GraphUtils.containsCycleIterative(matrix));
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
        assertFalse(GraphUtils.containsCycleRecursive(matrix));
    }

    @Test
    public void test04() {
        final int[][] matrix = new GraphBuilder()
                .setNodes(3)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .toMatrix();
        assertTrue(GraphUtils.containsCycleRecursive(matrix));
    }

    @Test
    public void test05() {
        final int[][] matrix = new GraphBuilder()
                .setNodes(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(1, 4)
                .addEdge(4, 2)
                .toMatrix();
        assertFalse(GraphUtils.containsCycleRecursive(matrix));
    }

    @Test
    public void test06() {
        final int[][] matrix = new GraphBuilder()
                .setNodes(5)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(1, 4)
                .addEdge(4, 2)
                .toMatrix();
        assertFalse(GraphUtils.containsCycleRecursive(matrix));
    }

    @Test
    public void test07() {
        final int[][] matrix = new GraphBuilder()
                .setNodes(2)
                .addEdge(0, 1)
                .addEdge(1, 0)
                .toMatrix();
        assertTrue(GraphUtils.containsCycleRecursive(matrix));
    }

    @Test
    public void test08() {
        final int[][] matrix = new GraphBuilder()
                .setNodes(6)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(4, 5)
                .toMatrix();
        assertFalse(GraphUtils.containsCycleRecursive(matrix));
    }

    @Test
    public void test09() {
        final int[][] matrix = new GraphBuilder()
                .setNodes(6)
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(4, 5)
                .addEdge(5, 4)
                .toMatrix();
        assertTrue(GraphUtils.containsCycleRecursive(matrix));
    }

    @Test
    public void test10() {
        final int[][] matrix = new GraphBuilder()
                .setNodes(6)
                .addEdge(1, 0)
                .addEdge(2, 0)
                .addEdge(3, 0)
                .addEdge(4, 0)
                .addEdge(5, 0)
                .toMatrix();
        assertFalse(GraphUtils.containsCycleRecursive(matrix));
    }
}
