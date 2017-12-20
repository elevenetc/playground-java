package su.levenetc.playground.java.math;

/**
 * Created by eugene.levenetc on 18/03/2017.
 */
public class GreatestCommonDivisor {

    public static long calc(long a, long b) {
        long rem = 1;
        while (rem != 0) {
            rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
}
