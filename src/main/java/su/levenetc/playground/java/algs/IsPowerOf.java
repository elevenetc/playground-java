package su.levenetc.playground.java.algs;

public class IsPowerOf {

    public static boolean two1(int value) {
        return isOneBit(value);
    }

    public static boolean two2(int value) {
        return value > 0 && (value & value - 1) == 0;
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
