package su.levenetc.playground.java.algs;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by eugene.levenetc on 10/03/2017.
 */
public class GrowingMedianImpl2 implements GrowingMedian {

    private PriorityQueue<Integer> smallNumsHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> largeNumsHeap = new PriorityQueue<>();

    public GrowingMedian add(int value) {
        if (smallNumsHeap.isEmpty()) {
            smallNumsHeap.add(value);
        } else if (smallNumsHeap.size() == largeNumsHeap.size()) {
            if (value > smallNumsHeap.peek()) {
                largeNumsHeap.add(value);
                smallNumsHeap.add(largeNumsHeap.remove());
            } else {
                smallNumsHeap.add(value);
            }
        } else if (smallNumsHeap.size() > largeNumsHeap.size()) {
            if (value > smallNumsHeap.peek()) {
                largeNumsHeap.add(value);
            } else {
                smallNumsHeap.add(value);
                largeNumsHeap.add(smallNumsHeap.remove());
            }
        }
        return this;
    }

    public double getMedian() {
        if (smallNumsHeap.size() == largeNumsHeap.size()) {
            return (smallNumsHeap.peek() + largeNumsHeap.peek()) / 2.0;
        } else {
            return smallNumsHeap.peek();
        }
    }
}
