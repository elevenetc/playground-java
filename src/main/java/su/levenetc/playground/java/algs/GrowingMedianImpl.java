package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.SortedArray;

/**
 * Created by eugene.levenetc on 10/03/2017.
 */
public class GrowingMedianImpl implements GrowingMedian {

    int index;
    SortedArray array;

    public GrowingMedianImpl(int size) {
        array = new SortedArray(size);
    }

    public GrowingMedian add(int value) {
        array.add(value);
        index++;
        return this;
    }

    public double getMedian() {
        if (index - 1 == 0) {
            return array.get(0);
        }
        int length = index;
        boolean isEven = length % 2 == 0;
        if (isEven) {
            int a = array.get(length / 2 - 1);
            int b = array.get(length / 2);
            return round((a + b) / 2f);
        } else {
            return array.get(length / 2);
        }
    }

    static float round(float value) {
        return (float) Math.round(value * 10f) / 10f;
    }
}
