package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 04/07/2017.
 */
public class DoctorAndEngineerFamily {

    public static String get(int pos) {
        final int bits = bitCount(pos - 1);
        return bits % 2 == 0 ? "Engineer" : "Doctor";
    }

    static int bitCount(int value) {
        int result = 0;
        while (value > 0) {
            if ((value & 1) == 1) result++;
            value >>= 1;
        }
        return result;
    }

}
