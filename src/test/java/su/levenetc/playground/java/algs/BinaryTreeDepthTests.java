package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.graphs.BinaryTreeDepth.iterative;
import static su.levenetc.playground.java.datastructures.Trees.perfectTree;
import static su.levenetc.playground.java.datastructures.Trees.unbalanced;

public class BinaryTreeDepthTests {
    @Test
    public void test() {
        assertEquals(3, iterative(perfectTree()));
        assertEquals(6, iterative(unbalanced()));
    }
}
