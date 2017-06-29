package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 23/06/2017.
 */
public class HouseRobber {
    public static int get(int[] houses) {
        int maxValue = 0;
        int sumValue = 0;
        for (int i = 0; i < houses.length; i++) {

            int value = houses[i];
            int tempMaxValue = maxValue;

            maxValue = Math.max(maxValue, sumValue);
            sumValue = value + tempMaxValue;
        }
        return Math.max(maxValue, sumValue);
    }
}