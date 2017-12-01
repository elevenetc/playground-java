package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.BNode;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.graphs.BinaryTreeDepth.maxIterative;
import static su.levenetc.playground.java.algs.graphs.BinaryTreeDepth.maxRecursive;
import static su.levenetc.playground.java.algs.graphs.BinaryTreeDepth.minIterative;
import static su.levenetc.playground.java.algs.graphs.BinaryTreeDepth.minRecursive;
import static su.levenetc.playground.java.datastructures.Trees.perfectTree;
import static su.levenetc.playground.java.datastructures.Trees.unbalanced;
import static su.levenetc.playground.java.datastructures.Trees.unbalanced2;

public class BinaryTreeDepthTests {
    @Test
    public void testMax() {
        assertEquals(3, maxIterative(perfectTree()));
        assertEquals(6, maxIterative(unbalanced()));

        assertEquals(3, maxRecursive(perfectTree()));
        assertEquals(6, maxRecursive(unbalanced()));
    }

    @Test
    public void testMin() {
        BNode root = unbalanced2();
        assertEquals(3, minIterative(root));
        assertEquals(3, minRecursive(root));
    }
}
