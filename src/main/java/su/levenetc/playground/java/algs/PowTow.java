package su.levenetc.playground.java.algs;

import java.math.BigInteger;

/**
 * Created by eugene.levenetc on 10/06/2017.
 */
public class PowTow {
    public static int get(int n) {
        BigInteger three = BigInteger.valueOf(3);
        BigInteger exp = BigInteger.valueOf(3);
        BigInteger mod = BigInteger.valueOf((long) (Math.pow(10, 9) + 7));

        BigInteger result = three.modPow(exp, mod);
        for (int i = 1; i < n; i++) {
            result = result.modPow(exp, mod);
        }
        return result.intValue();
    }
}
