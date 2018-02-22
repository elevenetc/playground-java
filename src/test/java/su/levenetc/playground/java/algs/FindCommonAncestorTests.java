package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.BTree;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.algs.FindCommonAncestor.withParent;
import static su.levenetc.playground.java.algs.FindCommonAncestor.withoutParent;
import static su.levenetc.playground.java.datastructures.Trees.perfectBalancedBST3;
import static su.levenetc.playground.java.datastructures.Trees.perfectBalancedBST4;

public class FindCommonAncestorTests {
    @Test
    public void test0() {
        BTree tree = new BTree(perfectBalancedBST3());
        test(tree, 100, 75, 125);
        test(tree, 50, 25, 75);
    }

    @Test
    public void test1() {
        BTree tree = new BTree(perfectBalancedBST4());
        test(tree, 10, 4, 16);
        test(tree, 5, 1, 8);
    }

    @Test
    public void test2() {
        BTree tree = new BTree(perfectBalancedBST4());
        test(tree, 15, 11, 18);
        test(tree, 10, 5, 15);
    }

    static void test(BTree tree, int expected, int nodeA, int nodeB) {
        assertEquals(expected, withParent(tree.get(nodeA), tree.get(nodeB)).value);
        assertEquals(expected, withoutParent(tree.root, tree.get(nodeA), tree.get(nodeB)).value);
    }
}