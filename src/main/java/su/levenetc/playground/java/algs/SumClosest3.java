package su.levenetc.playground.java.algs;

public class SumClosest3 {
    public static int get(int sum, int... array) {

        int valueMin = Integer.MAX_VALUE;
        int valueMid = Integer.MAX_VALUE;
        int valueMax = Integer.MAX_VALUE;

        int diffMin = Integer.MAX_VALUE;
        int diffMid = Integer.MAX_VALUE;
        int diffMax = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {

            int value = array[i];
            int diff = Math.abs(sum - value);

            if (diff < diffMin) {

                diffMax = diffMid;
                valueMax = valueMid;

                diffMid = diffMin;
                valueMid = valueMin;

                diffMin = diff;
                valueMin = value;

            } else if (diff < diffMid) {
                diffMax = diffMid;
                valueMax = valueMid;

                diffMid = diff;
                valueMid = value;
            } else if (diff < diffMax) {
                diffMax = diff;
                valueMax = value;
            }
        }

        return valueMin + valueMid + valueMax;
    }
}
