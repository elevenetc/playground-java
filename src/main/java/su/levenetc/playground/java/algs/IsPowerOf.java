package su.levenetc.playground.java.algs;

public class IsPowerOf {

    public static boolean two1(int value) {
        return isOneBit(value);
    }

    public static boolean two2(int value) {
        return value > 0 && (value & value - 1) == 0;
    }

    public static boolean three(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        if (n > 1) return n % 3 == 0 && three(n / 3);
        else return false;
    }

    public static boolean four(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        if (n > 1) return n % 4 == 0 && four(n / 4);
        else return false;
    }

    public static boolean x(int value, int power) {
        if (value == 0) return false;
        if (value == 1) return true;
        if (value > 1) return value % power == 0 && x(value / power, power);
        else return false;
    }

    static boolean isOneBit(int value) {
        if (value <= 0) return false;
        if (value <= 2) return true;
        boolean one = false;
        while (value > 0) {
            if ((value & 1) == 1) {
                if (one) {
                    return false;
                } else {
                    one = true;
                }
            }

            value = value >> 1;
        }
        return true;
    }
}
