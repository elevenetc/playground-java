package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.BNode;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.graphs.BinaryTreeDepth.maxIterative;
import static su.levenetc.playground.java.algs.graphs.BinaryTreeDepth.maxRecursive;
import static su.levenetc.playground.java.algs.graphs.BinaryTreeDepth.minIterative;
import static su.levenetc.playground.java.algs.graphs.BinaryTreeDepth.minRecursive;
import static su.levenetc.playground.java.datastructures.Trees.perfectNonBST;
import static su.levenetc.playground.java.datastructures.Trees.unbalancedNonBST;
import static su.levenetc.playground.java.datastructures.Trees.unbalancedNonBST2;

public class BinaryTreeDepthTests {
    @Test
    public void testMax() {
        assertEquals(3, maxIterative(perfectNonBST()));
        assertEquals(6, maxIterative(unbalancedNonBST()));

        assertEquals(3, maxRecursive(perfectNonBST()));
        assertEquals(6, maxRecursive(unbalancedNonBST()));
    }

    @Test
    public void testMin() {
        BNode root = unbalancedNonBST2();
        assertEquals(3, minIterative(root));
        assertEquals(3, minRecursive(root));
    }
}
