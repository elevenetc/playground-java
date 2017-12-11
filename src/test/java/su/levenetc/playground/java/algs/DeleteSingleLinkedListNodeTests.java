package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.LNode;
import su.levenetc.playground.java.utils.Out;

import static su.levenetc.playground.java.algs.DeleteSingleLinkedListNode.delete;

public class DeleteSingleLinkedListNodeTests {
    @Test
    public void test() {
        LNode list = LNode.list(1, 2, 3, 4);
        LNode toDelete = list.get(3);
        delete(toDelete);
        Out.pln(list);
    }
}
