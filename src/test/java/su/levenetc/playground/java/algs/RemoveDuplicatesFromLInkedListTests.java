package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.RemoveDuplicatesFromLInkedList.remove;
import static su.levenetc.playground.java.datastructures.IntNode.list;

public class RemoveDuplicatesFromLInkedListTests {
    @Test
    public void test() {
        assertTrue((remove(list(2, 3, 1, 5, 1)).deepEquals(list(2, 3, 1, 5))));
        assertTrue((remove(list(2, 3, 1, 1)).deepEquals(list(2, 3, 1))));
    }
}
