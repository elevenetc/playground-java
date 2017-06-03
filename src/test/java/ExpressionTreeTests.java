import org.junit.Test;

import su.levenetc.playground.java.datastructures.ExpressionTree;
import su.levenetc.playground.java.datastructures.ExpressionTree.Node;
import su.levenetc.playground.java.utils.Out;

import static su.levenetc.playground.java.datastructures.ExpressionTree.Type.INFIX;

/**
 * Created by eugene.levenetc on 03/06/2017.
 */
public class ExpressionTreeTests {
    @Test
    public void test01() {
        ExpressionTree tree = new ExpressionTree();

        tree.buildTree("Z*(A+B+C)/2", INFIX);
        final Node root = tree.getRoot();
        Out.pln(tree.toString(INFIX));

//        Node root = new Node('+');
//        Node left = new Node('A');
//        Node right = new Node('B');
//        root.left = left;
//        root.right = right;
//        tree.setRoot(root);
//        tree.print(ExpressionTree.Type.INFIX);
//        tree.print(ExpressionTree.Type.PREFIX);
//        tree.print(ExpressionTree.Type.POSTFIX);
    }
}
