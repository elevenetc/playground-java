import org.junit.Test;
import su.levenetc.playground.java.datastructures.BST2;
import su.levenetc.playground.java.datastructures.BT;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 06/02/2017.
 */
public class TestBinaryTree {
    @Test
    public void testPathSum() {
        BST2<Integer, String> bst = new BST2<>(10, "Top");
        bst.put(1, "1");
        bst.put(2, "2");

    }

    @Test
    public void maxDepth() {
        BT bt = new BT();
        bt.add(0);
        bt.add(1);
        bt.add(2);
        bt.add(3);

        assertEquals(3, goDown(bt.getRoot(), 0));
    }

    private int goDown(BT.Node node, int depth) {

        int left = 0;
        int right = 0;

        if (node.left != null) {
            left = goDown(node.left, ++depth);
        } else if (node.right != null) {
            right = goDown(node.right, ++depth);
        }

        if (left == 0 && right == 0) {
            return depth;
        } else {
            return left > right ? left : right;
        }

    }
}