package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 11/06/2017.
 */
public class PythTriplet {
    public static int[] get(int a) {
        int c, b;
        if (a % 2 == 0) {
            b = (int) Math.pow(a / 2, 2) - 1;
            c = b + 2;
        } else {
            b = ((int) Math.pow(a, 2) - 1) / 2;
            c = b + 1;
        }
        return new int[]{a, b, c};
    }
}
