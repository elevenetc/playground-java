import org.junit.Before;
import org.junit.Test;
import su.levenetc.playground.java.datastructures.BT;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 06/02/2017.
 */
public class TestBinaryTree {

    private BT bt;

    @Before
    public void before() {
        bt = new BT();
    }

    @Test
    public void maxDepth() {
        bt.add(0);
        bt.add(1);
        bt.add(-1);
        bt.add(2);
        bt.add(3);

        assertEquals(4, bt.getDepth());
    }

    @Test
    public void testMin() {
        bt.add(0);
        bt.add(-1);
        bt.add(-10);
        bt.add(2);
        bt.add(4);
        bt.add(6);

        assertEquals(-10, bt.minValue());
    }

    @Test
    public void printInOrder() {
        bt.add(-1).add(0).add(-3).add(-2).add(1).add(3).add(2).add(3);
        bt.printInOrder();
    }

    @Test
    public void printPostOrder() {
        bt.add(-1).add(0).add(1).add(3).add(-2);
        bt.printPostOrder();
    }

    @Test
    public void hasSum() {
        assertEquals(true, bt.add(0).add(1).add(2).add(3).hasPathSum(6));
        assertEquals(true, bt.add(0).add(1).add(2).add(-1).add(3).hasPathSum(6));
        assertEquals(true, bt.add(-1).add(2).add(-2).add(3).hasPathSum(4));
    }

    @Test
    public void printAllPaths() {
        bt.add(0).add(1).add(2).add(-1).add(-2).add(5).add(3).add(6)
                .printAllPaths();
    }


}