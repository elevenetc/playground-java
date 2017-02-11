import org.junit.Before;
import org.junit.Test;
import su.levenetc.playground.java.datastructures.BST;
import su.levenetc.playground.java.utils.Out;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 06/02/2017.
 */
public class TestBinaryTree {

    private BST bst;

    @Before
    public void before() {
        bst = new BST();
    }

    @Test
    public void maxDepth() {
        bst.add(0);
        bst.add(1);
        bst.add(-1);
        bst.add(2);
        bst.add(3);

        assertEquals(4, bst.getDepth());
    }

    @Test
    public void testMin() {
        bst.add(0);
        bst.add(-1);
        bst.add(-10);
        bst.add(2);
        bst.add(4);
        bst.add(6);

        assertEquals(-10, bst.minValue());
    }

    @Test
    public void printInOrder() {
        bst.add(-1).add(0).add(-3).add(-2).add(1).add(3).add(2).add(3);
        bst.printInOrder();
    }

    @Test
    public void printPostOrder() {
        bst.add(-1).add(0).add(1).add(3).add(-2);
        bst.printPostOrder();
    }

    @Test
    public void hasSum() {
        assertEquals(true, bst.add(0).add(1).add(2).add(3).hasPathSum(6));
        assertEquals(true, bst.add(0).add(1).add(2).add(-1).add(3).hasPathSum(6));
        assertEquals(true, bst.add(-1).add(2).add(-2).add(3).hasPathSum(4));
    }

    @Test
    public void printAllPaths() {
        bst.add(0).add(1).add(2).add(-1).add(-2).add(5).add(3).add(6)
                .printAllPaths();
    }

    @Test
    public void mirror() {
        bst.add(0).add(1).add(2).add(-1).add(-2).mirror();
    }

    @Test
    public void isEqual() {
        final BST bA = new BST().add(0).add(1).add(-1).add(-2).add(-3);
        final BST bB = new BST().add(0).add(1).add(-1).add(-2).add(-3);
        assertEquals(true, bA.isEqual(bB));

        final BST bC = new BST().add(0).add(1).add(-1).add(-2).add(-3);
        final BST bD = new BST().add(0).add(1).add(-1).add(-2).add(-3).add(-4);
        assertEquals(false, bC.isEqual(bD));
    }

    @Test
    public void printLayers() {
        bst.add(0).add(1).add(-1).add(2).add(-2).add(-3).add(-4).add(-5).add(3).printLayers();
        Out.pln();
        bst.clear();
        bst.add(5).add(6).add(2).add(4).add(1).add(3).printLayers();
    }

    @Test
    public void find() {
        bst.add(0).add(-1).add(1).add(-2).add(2).add(10).add(5);
        assertEquals(-1, bst.find(-1).value);
        assertEquals(10, bst.find(10).value);
        assertEquals(0, bst.find(0).value);
        assertEquals(null, bst.find(100));
        assertEquals(null, bst.find(-5));
    }

    @Test
    public void testRange() {
        bst.add(6).add(7).add(8).add(4).add(3).add(5);
        assertEquals(new ArrayList<Integer>() {{
            add(4);
            add(6);
            add(7);
        }}, bst.getRange(3, 8));
    }


}