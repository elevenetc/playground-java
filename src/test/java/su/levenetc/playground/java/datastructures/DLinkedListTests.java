package su.levenetc.playground.java.datastructures;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DLinkedListTests {
    @Test
    public void test() {
        DLinkedList.DNode n0 = new DLinkedList.DNode(0);
        DLinkedList.DNode n1 = new DLinkedList.DNode(1);
        DLinkedList.DNode n2 = new DLinkedList.DNode(2);

        DLinkedList list = new DLinkedList();

        assertThat(list.size()).isEqualTo(0);

        list.add(n0);

        assertThat(list.tail()).isEqualTo(n0);
        assertThat(list.head()).isEqualTo(n0);
        assertThat(list.size()).isEqualTo(1);

        list.add(n1);

        assertThat(list.tail()).isEqualTo(n0);
        assertThat(list.head()).isEqualTo(n1);
        assertThat(list.size()).isEqualTo(2);

        list.add(n2);

        assertThat(list.tail()).isEqualTo(n0);
        assertThat(list.head()).isEqualTo(n2);
        assertThat(list.size()).isEqualTo(3);

        list.remove(n1);

        assertThat(list.tail()).isEqualTo(n0);
        assertThat(list.head()).isEqualTo(n2);
        assertThat(list.size()).isEqualTo(2);

        list.remove(n0);

        assertThat(list.tail()).isEqualTo(n2);
        assertThat(list.head()).isEqualTo(n2);
        assertThat(list.size()).isEqualTo(1);

        list.remove(n2);

        assertThat(list.tail()).isNull();
        assertThat(list.head()).isNull();
        assertThat(list.size()).isEqualTo(0);
    }
}