package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.IntNode;
import su.levenetc.playground.java.utils.Out;

import static su.levenetc.playground.java.algs.DeleteSingleLinkedListNode.delete;

public class DeleteSingleLinkedListNodeTests {
    @Test
    public void test() {
        IntNode list = IntNode.list(1, 2, 3, 4);
        IntNode toDelete = list.get(3);
        delete(toDelete);
        Out.pln(list);
    }
}
