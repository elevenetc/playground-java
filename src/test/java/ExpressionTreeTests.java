import org.junit.Test;

import su.levenetc.playground.java.datastructures.ExpressionTree;
import su.levenetc.playground.java.datastructures.ExpressionTree.Node;

/**
 * Created by eugene.levenetc on 03/06/2017.
 */
public class ExpressionTreeTests {
    @Test
    public void test01() {
        ExpressionTree tree = new ExpressionTree();
        Node root = new Node('+');
        Node left = new Node('A');
        Node right = new Node('B');
        root.left = left;
        root.right = right;
        tree.setRoot(root);
        tree.print(ExpressionTree.Type.INFIX);
        tree.print(ExpressionTree.Type.PREFIX);
        tree.print(ExpressionTree.Type.POSTFIX);
    }
}
