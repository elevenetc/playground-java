package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.algs.stacks.TwoStackQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TwoStackQueueTests {
    @Test
    public void test() {
        TwoStackQueue queue = new TwoStackQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertEquals(1, queue.peek());
        assertEquals(1, queue.size());
    }
}
