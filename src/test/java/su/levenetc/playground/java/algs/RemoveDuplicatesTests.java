package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.LNode;

import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.RemoveDuplicates.removeDuplicatesFree;
import static su.levenetc.playground.java.algs.RemoveDuplicates.removeDuplicatesMem;
import static su.levenetc.playground.java.datastructures.LNode.list;

public class RemoveDuplicatesTests {
    @Test
    public void test01() {
        LNode list = list(1, 2, 3);
        assertTrue(list(1, 2, 3).valueEquals(removeDuplicatesFree(list)));
        assertTrue(list(1, 2, 3).valueEquals(removeDuplicatesMem(list)));
    }

    @Test
    public void test02() {
        assertTrue(list(1, 2, 3).valueEquals(removeDuplicatesFree(list(1, 2, 2, 3))));
        assertTrue(list(1, 2, 3).valueEquals(removeDuplicatesMem(list(1, 2, 2, 3))));
    }

}
