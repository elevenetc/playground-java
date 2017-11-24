package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.datastructures.ListNode;
import su.levenetc.playground.java.utils.Out;

import static su.levenetc.playground.java.algs.DeleteSingleLinkedListNode.delete;

public class DeleteSingleLinkedListNodeTests {
    @Test
    public void test() {
        ListNode list = ListNode.list(1, 2, 3, 4);
        ListNode toDelete = list.get(3);
        delete(toDelete);
        Out.pln(list);
    }
}
