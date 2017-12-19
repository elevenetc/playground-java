package su.levenetc.playground.java.algs;

public class ReverseInteger {
    public static int reverse(int in) {
        if (in > -10 && in < 10) return in;

        int sign = Integer.signum(in);
        int out = 0;
        in = Math.abs(in);
        while (in != 0) {
            int rem = in % 10;
            in /= 10;

            if (checkOutOfInt(out, rem)) {
                return 0;
            } else {
                out = out * 10 + rem;
            }
        }
        return sign == 0 ? out : out * sign;
    }

    private static boolean checkOutOfInt(int a, int b) {
        long res = (long) a * 10 + (long) b;
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE;
    }
}
