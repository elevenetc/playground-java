package su.levenetc.playground.java.algs;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int get(int k, int... array) {

        if (array.length == 1) {
            return array[0];
        } else if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : array) {
            pq.add(i);
            if (pq.size() > k) pq.poll();
        }

        return pq.peek();
    }
}