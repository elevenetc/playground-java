package su.levenetc.playground.java.datastructures;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CircularQueueTest {

    @Test
    public void enQueue() {
        CircularQueue queue = new CircularQueue(3);
        assertThat(queue.enQueue(0)).isTrue();
        assertThat(queue.enQueue(1)).isTrue();
        assertThat(queue.enQueue(2)).isTrue();
        assertThat(queue.enQueue(2)).isFalse();
    }

    @Test
    public void deQueue() {
        CircularQueue queue = new CircularQueue(3);
        assertThat(queue.deQueue()).isFalse();
        queue.enQueue(0);
        queue.enQueue(1);
        queue.enQueue(2);
        assertThat(queue.deQueue()).isTrue();
        assertThat(queue.deQueue()).isTrue();
        assertThat(queue.deQueue()).isTrue();
        assertThat(queue.deQueue()).isFalse();
    }

    @Test
    public void front() {
        CircularQueue queue = new CircularQueue(3);
        queue.enQueue(0);
        assertThat(queue.Front()).isEqualTo(0);
        queue.enQueue(1);
        assertThat(queue.Front()).isEqualTo(0);
    }

    @Test
    public void rear() {
        CircularQueue queue = new CircularQueue(3);
        queue.enQueue(0);
        assertThat(queue.Rear()).isEqualTo(0);
        queue.enQueue(1);
        assertThat(queue.Rear()).isEqualTo(1);
    }

    @Test
    public void isEmpty() {
        CircularQueue queue = new CircularQueue(3);
        assertThat(queue.isEmpty()).isTrue();
        queue.enQueue(1);
        assertThat(queue.isEmpty()).isFalse();
        queue.deQueue();
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    public void isFull() {
        CircularQueue queue = new CircularQueue(3);
        assertThat(queue.isFull()).isFalse();
        queue.enQueue(0);
        assertThat(queue.isFull()).isFalse();
        queue.enQueue(1);
        assertThat(queue.isFull()).isFalse();
        queue.enQueue(2);
        assertThat(queue.isFull()).isTrue();
        queue.deQueue();
        assertThat(queue.isFull()).isFalse();
    }
}