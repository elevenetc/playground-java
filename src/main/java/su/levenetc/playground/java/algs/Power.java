package su.levenetc.playground.java.algs;

public class Power {
    public static float get(int value, int power) {
        if (value == 1) return 1;
        if (power == 0) return 1;

        int sign = 1;
        if (value < 0) sign = value % 2 == 0 ? 1 : -1;
        float result;

        if (power < 0) result = 1f / internal(value, -power);
        else result = internal(value, power);
        return result * sign;
    }

    static int internal(int value, int pow) {
        if (pow == 1) return value;
        else if (pow == 2) return value * value;
        else return value * internal(value, pow - 1);
    }
}
