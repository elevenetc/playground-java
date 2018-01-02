package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.algs.trees.RandomBST;
import su.levenetc.playground.java.utils.Out;

public class RandomBSTTests {
    @Test
    public void test() {
        RandomBST tree = new RandomBST();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(8);
        tree.insert(10);

        tree.printByLayers();
        Out.pln();
        tree.printInOrder();
        Out.pln();
        Out.pln(0, tree.getRandom(0));
        Out.pln(1, tree.getRandom(1));
        Out.pln(2, tree.getRandom(2));
        Out.pln(3, tree.getRandom(3));
        Out.pln(4, tree.getRandom(4));
        Out.pln(5, tree.getRandom(5));
        Out.pln(6, tree.getRandom(6));
        Out.pln(7, tree.getRandom(7));
    }
}
