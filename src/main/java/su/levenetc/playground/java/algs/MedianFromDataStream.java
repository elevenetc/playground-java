package su.levenetc.playground.java.algs;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFromDataStream {

    PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> hi = new PriorityQueue<>();

    public void add(int num) {

        lo.add(num);
        hi.add(lo.poll());

        if (lo.size() < hi.size()) {
            lo.add(hi.poll());
        }
    }

    public double median() {
        return lo.size() > hi.size() ? (double) lo.peek() : (lo.peek() + hi.peek()) * 0.5;
    }
}
