import org.junit.Test;
import su.levenetc.playground.java.datastructures.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by eugene.levenetc on 14/04/2017.
 */
public class TestUtils {
    @Test
    public void testAssertions() {
        List<Set<Node>> sets = new ArrayList<>();
        sets.add(Node.nodesSet(1, 2, 3));
        AssertUtils.assertContains(sets, new Node(1));
    }
}
