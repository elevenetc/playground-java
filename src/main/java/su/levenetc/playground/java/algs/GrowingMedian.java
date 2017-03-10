package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.SortedArray;

/**
 * Created by eugene.levenetc on 10/03/2017.
 */
public class GrowingMedian {

    int index;
    SortedArray array;

    public GrowingMedian(int size) {
        //array = new int[size];
        array = new SortedArray(size);
    }

    public float add(int value) {
        array.add(value);
        final float result = getMedian();
        index++;
        return result;
    }

    float getMedian() {
        if (index == 0) {
            return array.get(0);
        }
        int length = index + 1;
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
