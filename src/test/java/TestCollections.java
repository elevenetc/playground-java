import org.junit.Test;
import su.levenetc.playground.java.utils.Out;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 10/03/2017.
 */
public class TestCollections {
    @Test
    public void testPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(1);
        pq.add(100);
        assertEquals(true, Arrays.equals(new Object[]{1, 10, 100}, pq.toArray()));
        Out.pln(pq.peek());
        for (int i : pq) {
            Out.pln(i);
        }
    }

    @Test
    public void testReverseOrder() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqReverse = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(3);
        pq.add(1);
        pq.add(2);

        pqReverse.add(3);
        pqReverse.add(1);
        pqReverse.add(2);

        assertEquals(true, 1 == pq.peek());
        assertEquals(true, 3 == pqReverse.peek());
    }

    @Test
    public void testRemoveOrder() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(2);
        pq.add(1);
        pq.remove();
        if(pq == null){

        }
    }
}