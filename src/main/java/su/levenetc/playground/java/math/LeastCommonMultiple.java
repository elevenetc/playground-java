package su.levenetc.playground.java.math;

/**
 * Created by eugene.levenetc on 18/03/2017.
 */
public class LeastCommonMultiple {
    public static long calc(long a, long b) {
        return a * (b / GreatestCommonDivisor.calc(a, b));
    }
}
