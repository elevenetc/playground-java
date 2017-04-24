package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 24/04/2017.
 */
public class PowerSum {

    public static int powerSum(int max, int power) {
        return powerSumInternal(max, power, 1, 0);
    }

    private static int powerSumInternal(int max, int power, int base, int currentSum) {

        int currentValue = (int) Math.pow(base, power);

        if (currentValue + currentSum > max) {
            return 0;
        } else if (currentValue == max || currentValue + currentSum == max) {
            return 1;
        } else {
            return powerSumInternal(max, power, base + 1, currentSum) + powerSumInternal(max, power, base + 1, currentSum + currentValue);
        }
    }
}
