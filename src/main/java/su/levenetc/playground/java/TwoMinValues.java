package su.levenetc.playground.java;

/**
 * Created by eugene.levenetc on 23/05/2017.
 */
public class TwoMinValues {
    public static int[] get(int... values) {
        int minA = Integer.MAX_VALUE;
        int minB = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            int value = values[i];

            if (value < minA) {
                minB = minA;
                minA = value;
            } else if (value < minB) {
                minB = value;
            }
        }
        return new int[]{minA, minB};
    }
}
