package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.BTree;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.FindCommonAncestor.withParent;
import static su.levenetc.playground.java.datastructures.Trees.perfectBalancedBST3;
import static su.levenetc.playground.java.datastructures.Trees.perfectBalancedBST4;

public class FindCommonAncestorTests {
    @Test
    public void test0() {
        BTree tree = new BTree(perfectBalancedBST3());
        assertEquals(100, withParent(tree.get(75), tree.get(125)).value);
        assertEquals(50, withParent(tree.get(25), tree.get(75)).value);
    }

    @Test
    public void test1() {
        BTree tree = new BTree(perfectBalancedBST4());
        assertEquals(10, withParent(tree.get(4), tree.get(16)).value);
        assertEquals(5, withParent(tree.get(1), tree.get(8)).value);
    }
}