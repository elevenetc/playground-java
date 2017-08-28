import org.junit.Test;

import su.levenetc.playground.java.datastructures.layeredtree.Node;

import static su.levenetc.playground.java.datastructures.layeredtree.Node.fromA;
import static su.levenetc.playground.java.datastructures.layeredtree.Node.nodeA;
import static su.levenetc.playground.java.datastructures.layeredtree.Node.nodeB;

public class LayeredTreeTests {
    @Test
    public void test01() {
        Node root =
                fromA("root-a")
                        .then(
                                nodeB("b-1").then(nodeA("a")),
                                nodeB("b-2")
                        )
                        .end();

    }
}
