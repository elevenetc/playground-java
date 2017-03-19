import org.junit.Test;
import su.levenetc.playground.java.graphs.AdjMatrix;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 18/03/2017.
 */
public class TestAdjMatrix {

    @Test
    public void testDFS() {
        AdjMatrix matrix = new AdjMatrix(6);
        matrix.addConnection(0, 1);
        matrix.addConnection(0, 2);
        matrix.addConnection(2, 0);
        matrix.addConnection(2, 3);
        matrix.addConnection(4, 5);

        assertEquals(true, matrix.dfs(0, 3));
        assertEquals(true, matrix.dfs(1, 2));
        assertEquals(true, matrix.dfs(1, 3));
        assertEquals(true, matrix.dfs(4, 5));
        assertEquals(false, matrix.dfs(0, 5));
    }

    @Test
    public void testDFS2() {
        AdjMatrix matrix = new AdjMatrix(4);
        matrix.addConnection(0, 1);
        matrix.addConnection(2, 1);
        matrix.addConnection(3, 2);

        assertEquals(true, matrix.dfs(0, 3));
    }

    @Test
    public void testDFS3() {
        AdjMatrix matrix = new AdjMatrix(5);
        matrix.addConnection(0, 1);
        matrix.addConnection(3, 4);

        assertEquals(false, matrix.dfs(0, 4));
    }
}
