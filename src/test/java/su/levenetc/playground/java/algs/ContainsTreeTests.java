package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.BNode;
import su.levenetc.playground.java.datastructures.BTree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.trees.ContainsTree.contains1;
import static su.levenetc.playground.java.algs.trees.ContainsTree.contains2;
import static su.levenetc.playground.java.datastructures.Trees.balancedBST4;
import static su.levenetc.playground.java.datastructures.Trees.nonBST;
import static su.levenetc.playground.java.datastructures.Trees.simleLeftNonBST;
import static su.levenetc.playground.java.datastructures.Trees.simleRightNonBST;

public class ContainsTreeTests {
    @Test
    public void success() {
        BTree t1 = new BTree(balancedBST4());
        BTree t2 = new BTree(nonBST());

        BNode n8 = t1.get(8);

        n8.left = t2.root;

        assertTrue(contains1(t1.root, t2.root));
        assertTrue(contains2(t1.root, t2.root));
    }

    @Test
    public void fail() {
        BTree t1 = new BTree(balancedBST4());
        BTree t2 = new BTree(nonBST());

        assertFalse(contains1(t1.root, t2.root));
        assertFalse(contains2(t1.root, t2.root));

        assertFalse(contains1(simleLeftNonBST(), simleRightNonBST()));
        assertFalse(contains2(simleLeftNonBST(), simleRightNonBST()));
    }

}
