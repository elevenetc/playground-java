package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

public class Power {
    public static int get(int value, int power) {
        Map<Integer, Integer> mem = new HashMap<>();
        return internal(value, power, mem);
    }

    static int internal(int value, int pow, Map<Integer, Integer> mem) {
        if (pow == 1) return value;
        else if (pow == 2) return value * value;
        else return value * internal(value, pow - 1, mem);
    }
}
